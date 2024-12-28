import json
import requests
import logging
import time
import os
import sys

if __name__ == '__main__':
    # Configure logging to display messages with timestamps
    logging.basicConfig(
        level=logging.INFO,
        format='%(asctime)s - %(levelname)s - %(message)s',
        handlers=[
            # logging.FileHandler("send_users.log"),  # Log messages to a file
            logging.StreamHandler()  # Also log messages to the console
        ]
    )

    # Path to the JSON file containing user profiles
    json_file_path = os.path.join(os.path.dirname(__file__), 'request.json')

    # Check if the JSON file exists
    if not os.path.exists(json_file_path):
        logging.error(f"JSON file '{json_file_path}' not found. Please ensure the file exists.")
        exit(1)

    # Load JSON data from the file
    try:
        with open(json_file_path, 'r', encoding='utf-8') as file:
            users = json.load(file)
            logging.info(f"Successfully loaded {len(users)} user profiles from '{json_file_path}'.")
    except json.JSONDecodeError as e:
        logging.error(f"Error decoding JSON: {e}")
        exit(1)
    except Exception as e:
        logging.error(f"An unexpected error occurred while reading '{json_file_path}': {e}")
        exit(1)

    # API endpoint URL
    baseUrl = 'http://localhost:8080'

    # check system arguments
    if len(sys.argv) > 1:
        baseUrl = sys.argv[1]
    
    url = baseUrl + '/api/user'

    # Optional: Define headers if your API requires them
    headers = {
        'Content-Type': 'application/json'
        # Add other headers here if necessary, e.g., Authorization tokens
    }

    # Iterate over each user and send a POST request
    for idx, user in enumerate(users, start=1):
        try:
            response = requests.post(url, headers=headers, json=user)
            if response.status_code in [200, 201]:
                logging.info(f"[{idx}/{len(users)}] Successfully sent user: {user['name']}")
            else:
                logging.error(f"[{idx}/{len(users)}] Failed to send user: {user['name']}. "
                            f"Status Code: {response.status_code}. Response: {response.text}")
        except requests.exceptions.RequestException as e:
            logging.error(f"[{idx}/{len(users)}] Exception occurred while sending user: {user['name']}. Error: {e}")
        
        # Optional: Sleep between requests to avoid overwhelming the server
        time.sleep(0.1)  # Sleep for 100 milliseconds

    logging.info("All POST requests have been processed.")
