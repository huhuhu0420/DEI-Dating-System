# Class Diagram

## Completed

![uml](images/uml.png)

```mermaid
classDiagram
direction BT

class AgeRange {
  +AgeRange(int, int)
  -int minAge
  -int maxAge
}

class AgeRangeSpecification {
  +AgeRangeSpecification(int, int)
  +isSatisfiedBy(UserProfile) boolean
}

class AndSpecification {
  +AndSpecification(Specification, Specification)
  +isSatisfiedBy(Object) boolean
}

class BasicUser {
  +BasicUser(String, UserProfile)
  +BasicUser(UserProfile)
  -String username
  -UserProfile userProfile
  +String description
  +boolean premium
}

class BiDirectionalStrategy {
  +BiDirectionalStrategy()
  +match(User, List~User~, SpecificationBuilder) List~User~
}

class DefaultCompatibilityMatrix {
  -DefaultCompatibilityMatrix()
  -DefaultCompatibilityMatrix instance
  +getDefaultPreferencedGenderIdentities(SexualOrientation, GenderIdentity) List~GenderIdentity~
  -List~GenderIdentity~ getAllGenderIdentitiesExcluding(GenderIdentity)
  -List~GenderIdentity~ getOppositeGender(GenderIdentity)
  -List~GenderIdentity~ getSameGender(GenderIdentity)
  -initializeDefaultMappings() void
  +List~GenderIdentity~ allGenderIdentities
}

class DefaultMatchStrategy {
  +DefaultMatchStrategy()
  +match(User, List~User~, SpecificationBuilder) List~User~
}

class DeiResources {
  +DeiResources()
  +match(UserData) Response
  +createUser(UserData) Response
}

class GenderIdentity {
  +GenderIdentity()
  +GenderIdentity(GenderIdentityEnum)
  +GenderIdentity(GenderIdentityEnum, String)
  -GenderIdentityEnum genderIdentityEnum
  -String genderIdentity
  +String customGenderIdentity
}

class GenderIdentityEnum {
  <<enumeration>>
  +valueOf(String) GenderIdentityEnum
  +values() GenderIdentityEnum[]
  +String displayName
}

class IdentitySpecification {
  +IdentitySpecification(List~GenderIdentity~)
  +isSatisfiedBy(UserProfile) boolean
}

class InterestSpecification {
  +InterestSpecification(List~String~)
  +isSatisfiedBy(UserProfile) boolean
}

class JerseyConfig {
  +JerseyConfig()
}

class JettyServer {
  +JettyServer()
  +main(String[]) void
}

class Main {
  +Main()
  +main(String[]) void
}

class MatchStrategy {
  <<Interface>>
  +match(User, List~User~, SpecificationBuilder) List~User~
}

class MatchingEngine {
  +MatchingEngine(List~User~)
  +match(User, SpecificationBuilder) List~User~
  -MatchStrategy matchStrategy
}

class OrSpecification {
  +OrSpecification(Specification, Specification)
  +isSatisfiedBy(Object) boolean
}

class PreferenceProfile {
  +PreferenceProfile(List~GenderIdentity~, List~String~, AgeRange)
  -List~GenderIdentity~ preferedGenderIdentity
  -AgeRange preferedAgeRange
  -List~String~ preferedInterests
}

class PreferenceProfileBuilder {
  +PreferenceProfileBuilder()
  +build() PreferenceProfile
  +setAgeRange(int, int) PreferenceProfileBuilder
  +addPreferenceGenderIdentity(GenderIdentityEnum) PreferenceProfileBuilder
  +addPreferenceGenderIdentityWithEnum(GenderIdentityEnum, String) PreferenceProfileBuilder
  -List~GenderIdentity~ preferedGenderIdentity
  -List~String~ preferedInterests
}

class PremiumUser {
  +PremiumUser(UserProfile)
  +PremiumUser(String, UserProfile)
  -UserProfile userProfile
  -String username
  +String description
  +boolean premium
}

class SexualOrientation {
  <<enumeration>>
  +valueOf(String) SexualOrientation
  +values() SexualOrientation[]
}

class Specification {
  <<Interface>>
  +or(Specification) Specification
  +isSatisfiedBy(Object) boolean
  +and(Specification) Specification
}

class SpecificationBuilder {
  +SpecificationBuilder()
  +buildSpecificationFromPreferences(UserProfile) Specification
}

class User {
  <<Interface>>
  +String description
  +String username
  +boolean premium
  +UserProfile userProfile
}

class UserData {
  +UserData()
  -List~String~ interests
  -int preferedMinAge
  -int age
  -String name
  -List~GenderIdentity~ preferedGenderIdentity
  -String matchStrategy
  -GenderIdentity genderIdentity
  -int preferedMaxAge
  -String bio
  -boolean premium
  -List~String~ preferedInterests
  -SexualOrientation sexualOrientation
  +String name
  +int age
  +String bio
  +String matchStrategy
  +List~String~ interests
  +boolean premium
  +GenderIdentity genderIdentity
  +int preferedMaxAge
  +SexualOrientation sexualOrientation
  +int preferedMinAge
  +List~GenderIdentity~ preferedGenderIdentity
  +List~String~ preferedInterests
}

class UserFactory {
  -UserFactory()
  -List~User~ users
  +createUser(String, UserProfile, boolean) User
  +clearUsers() void
  +addUser(User) void
  +createUser(UserProfile, boolean) User
}

class UserMapper {
  +UserMapper()
  +toDTO(User) UserData
  +toEntity(UserData) User
}

class UserProfile {
  +UserProfile(String, int, GenderIdentity, SexualOrientation, String, List~String~)
  -List~String~ interests
  -SexualOrientation sexualOrientation
  -String bio
  -int age
  -String name
  -PreferenceProfile preferenceProfile
  -GenderIdentity genderIdentity
}

class UserProfileBuilder {
  +UserProfileBuilder()
  +setGenderIdentity(GenderIdentityEnum, String) UserProfileBuilder
  +build() UserProfile
  -GenderIdentity genderIdentity
  -List~String~ interests
  -int age
  -String bio
  -SexualOrientation sexualOrientation
  -String name
}

class UserService {
  +UserService()
  +match(UserData) List~UserData~
  +createUser(UserData) User
}

%% Relationships

AgeRangeSpecification ..|> Specification
AgeRangeSpecification ..> UserProfile

AndSpecification ..|> Specification
AndSpecification --> Specification : leftSpecification

BasicUser ..|> User
BasicUser --> UserProfile : userProfile

BiDirectionalStrategy ..|> MatchStrategy
BiDirectionalStrategy ..> Specification
BiDirectionalStrategy ..> SpecificationBuilder
BiDirectionalStrategy ..> User
BiDirectionalStrategy ..> UserProfile

DefaultCompatibilityMatrix --> DefaultCompatibilityMatrix : create
DefaultCompatibilityMatrix --> GenderIdentity : create
DefaultCompatibilityMatrix --> GenderIdentityEnum
DefaultCompatibilityMatrix --> SexualOrientation : defaultMappings

DefaultMatchStrategy ..|> MatchStrategy
DefaultMatchStrategy ..> Specification
DefaultMatchStrategy ..> SpecificationBuilder
DefaultMatchStrategy ..> User
DefaultMatchStrategy ..> UserProfile

DeiResources ..> UserData
DeiResources ..> UserService : create

GenderIdentity --> GenderIdentityEnum : genderIdentityEnum

IdentitySpecification --> GenderIdentity : preferedGenderIdentities
IdentitySpecification ..|> Specification
IdentitySpecification ..> UserProfile

InterestSpecification ..|> Specification
InterestSpecification ..> UserProfile

JettyServer ..> JerseyConfig
JettyServer ..> Main

Main --> BiDirectionalStrategy : create
Main --> DefaultMatchStrategy : create
Main --> GenderIdentityEnum
Main --> MatchingEngine : create
Main --> PreferenceProfile
Main --> PreferenceProfileBuilder : create
Main --> SexualOrientation
Main --> SpecificationBuilder : create
Main --> User
Main --> UserFactory
Main --> UserProfile
Main --> UserProfileBuilder : create

MatchStrategy ..|> SpecificationBuilder
MatchStrategy ..> User

MatchingEngine ..> DefaultMatchStrategy : create
MatchingEngine --> MatchStrategy : matchingStrategy
MatchingEngine ..> SpecificationBuilder
MatchingEngine --> User : candidates

OrSpecification ..|> Specification
OrSpecification --> Specification : leftSpecification

PreferenceProfile --> AgeRange : preferedAgeRange
PreferenceProfile --> GenderIdentity : preferedGenderIdentity

PreferenceProfileBuilder --> AgeRange : create
PreferenceProfileBuilder --> GenderIdentity : create
PreferenceProfileBuilder --> GenderIdentityEnum
PreferenceProfileBuilder --> PreferenceProfile : build
PreferenceProfileBuilder --> PreferenceProfileBuilder

PremiumUser ..|> User
PremiumUser --> UserProfile : userProfile

Specification ..|> AndSpecification : create
Specification ..|> OrSpecification : create

SpecificationBuilder --> AgeRange
SpecificationBuilder --> AgeRangeSpecification : create
SpecificationBuilder --> IdentitySpecification : create
SpecificationBuilder --> InterestSpecification : create
SpecificationBuilder --> PreferenceProfile
SpecificationBuilder --> Specification
SpecificationBuilder --> UserProfile

User --> UserProfile

UserData --> GenderIdentity : preferedGenderIdentity
UserData --> SexualOrientation : sexualOrientation

UserFactory ..|> BasicUser : create
UserFactory ..|> PremiumUser : create
UserFactory --> User : users

UserMapper --> AgeRange
UserMapper --> PreferenceProfile
UserMapper --> PreferenceProfileBuilder : create
UserMapper --> User
UserMapper --> UserData : create
UserMapper --> UserFactory
UserMapper --> UserProfile
UserMapper --> UserProfileBuilder : create

UserProfile --> DefaultCompatibilityMatrix
UserProfile --> GenderIdentity : genderIdentity
UserProfile --> GenderIdentityEnum
UserProfile --> PreferenceProfile
UserProfile --> PreferenceProfileBuilder : create
UserProfile --> SexualOrientation

UserProfileBuilder --> GenderIdentity : create
UserProfileBuilder --> SexualOrientation
UserProfileBuilder --> UserProfile : build
UserProfileBuilder --> UserProfileBuilder

UserService --> BiDirectionalStrategy : create
UserService --> MatchingEngine : create
UserService --> SpecificationBuilder : create
UserService --> User
UserService --> UserData
UserService --> UserFactory
UserService --> UserMapper
```

## Components

### Model

```mermaid
classDiagram
direction BT

class AgeRange {
    + AgeRange(int minAge, int maxAge)
    - int minAge
    - int maxAge
}

class BasicUser {
    + BasicUser(UserProfile userProfile)
    + BasicUser(String username, UserProfile userProfile)
    ~ UserProfile userProfile
    ~ String username
    ~ String description
    ~ boolean premium
}

class GenderIdentity {
    + GenderIdentity(GenderIdentityEnum genderIdentityEnum, String customGenderIdentity)
    + GenderIdentity()
    + GenderIdentity(GenderIdentityEnum genderIdentityEnum)
    - GenderIdentityEnum genderIdentityEnum
    - String genderIdentity
    - String customGenderIdentity
}

class GenderIdentityEnum {
<<enumeration>>
    - String displayName
    + values() GenderIdentityEnum[]
    + valueOf(String name) GenderIdentityEnum
}

class PreferenceProfile {
    + PreferenceProfile(List~GenderIdentity~ genderIdentities, 
                       List~String~ interests, 
                       AgeRange ageRange)
    - List~String~ preferedInterests
    - AgeRange preferedAgeRange
    - List~GenderIdentity~ preferedGenderIdentity
}

class PreferenceProfileBuilder {
    + PreferenceProfileBuilder()
    + addPreferenceGenderIdentityWithEnum(GenderIdentityEnum enumVal, String customValue) PreferenceProfileBuilder
    + addPreferenceGenderIdentity(GenderIdentityEnum enumVal) PreferenceProfileBuilder
    + setAgeRange(int minAge, int maxAge) PreferenceProfileBuilder
    + build() PreferenceProfile
    - List~GenderIdentityEnum~ preferedGenderIdentityWithEnum
    - List~GenderIdentity~ preferedGenderIdentity
    - List~String~ preferedInterests
}

class PremiumUser {
    + PremiumUser(String username, UserProfile userProfile)
    + PremiumUser(UserProfile userProfile)
    - UserProfile userProfile
    - String username
    - String description
    - boolean premium
}

class SexualOrientation {
<<enumeration>>
    + values() SexualOrientation[]
    + valueOf(String name) SexualOrientation
}

class User {
<<Interface>>
    String description
    String username
    boolean premium
    UserProfile userProfile
}

class UserFactory {
    - UserFactory()
    - List~User~ users
    + createUser(UserProfile userProfile, boolean premium) User
    + createUser(String username, UserProfile userProfile, boolean premium) User
    + addUser(User user) void
    + clearUsers() void
}

class UserProfile {
    + UserProfile(String name, int age, 
                  GenderIdentity genderIdentity, 
                  SexualOrientation sexualOrientation, 
                  String bio, 
                  List~String~ interests)
    - String name
    - int age
    - String bio
    - List~String~ interests
    - GenderIdentity genderIdentity
    - SexualOrientation sexualOrientation
    - PreferenceProfile preferenceProfile
}

class UserProfileBuilder {
    + UserProfileBuilder()
    + setGenderIdentity(GenderIdentityEnum enumVal, String customValue) UserProfileBuilder
    + build() UserProfile
    - String name
    - int age
    - String bio
    - List~String~ interests
    - GenderIdentity genderIdentity
    - SexualOrientation sexualOrientation
    - GenderIdentityEnum genderIdentityWithEnum
}

%% RELATIONSHIPS

BasicUser  ..>  User
BasicUser "1" *--> "userProfile 1" UserProfile

GenderIdentity "1" *--> "genderIdentityEnum 1" GenderIdentityEnum

PreferenceProfile "1" *--> "preferedAgeRange 1" AgeRange
PreferenceProfile "1" *--> "preferedGenderIdentity *" GenderIdentity

PreferenceProfileBuilder "1" *--> "ageRange 1" AgeRange
PreferenceProfileBuilder ..> AgeRange : «create»
PreferenceProfileBuilder ..> GenderIdentity : «create»
PreferenceProfileBuilder "1" *--> "preferedGenderIdentity *" GenderIdentity
PreferenceProfileBuilder ..> GenderIdentityEnum
PreferenceProfileBuilder ..> PreferenceProfile : «create»
PreferenceProfileBuilder ..> PreferenceProfileBuilder

PremiumUser ..> User
PremiumUser "1" *--> "userProfile 1" UserProfile

User ..> UserProfile

UserFactory ..> BasicUser : «create»
UserFactory ..> PremiumUser : «create»
UserFactory "1" *--> "users *" User
UserFactory ..> UserProfile

UserProfile "1" *--> "genderIdentity 1" GenderIdentity
UserProfile ..> GenderIdentityEnum
UserProfile "1" *--> "preferenceProfile 1" PreferenceProfile
UserProfile ..> PreferenceProfileBuilder : «create»
UserProfile "1" *--> "sexualOrientation 1" SexualOrientation

UserProfileBuilder "1" *--> "genderIdentity 1" GenderIdentity
UserProfileBuilder ..> GenderIdentity : «create»
UserProfileBuilder ..> GenderIdentityEnum
UserProfileBuilder "1" *--> "sexualOrientation 1" SexualOrientation
UserProfileBuilder ..> UserProfile : «create»
UserProfileBuilder ..> UserProfileBuilder

```

### Specification

```mermaid
classDiagram
direction BT

class Specification~T~ {
  <<interface>>
  + isSatisfiedBy(T item) boolean
  + and(Specification~T~ otherSpec) Specification~T~
  + or(Specification~T~ otherSpec) Specification~T~
}

class AgeRangeSpecification {
  + AgeRangeSpecification(int minAge, int maxAge)
  + isSatisfiedBy(UserProfile user) boolean
}

class AndSpecification~T~ {
  + AndSpecification(Specification~T~ leftSpec, Specification~T~ rightSpec)
  + isSatisfiedBy(T item) boolean
}

class OrSpecification~T~ {
  + OrSpecification(Specification~T~ leftSpec, Specification~T~ rightSpec)
  + isSatisfiedBy(T item) boolean
}

class IdentitySpecification {
  + IdentitySpecification(List~GenderIdentity~ allowedIdentities)
  + isSatisfiedBy(UserProfile user) boolean
}

class InterestSpecification {
  + InterestSpecification(List~String~ allowedInterests)
  + isSatisfiedBy(UserProfile user) boolean
}

class SpecificationBuilder {
  + SpecificationBuilder()
  + buildSpecificationFromPreferences(UserProfile user) Specification~UserProfile~
}

%% IMPLEMENTS / EXTENDS
AgeRangeSpecification ..|> Specification~UserProfile~
IdentitySpecification ..|> Specification~UserProfile~
InterestSpecification ..|> Specification~UserProfile~

AndSpecification~T~ ..|> Specification~T~
OrSpecification~T~  ..|> Specification~T~

%% ASSOCIATIONS
AndSpecification~T~ "1" o-- "leftSpecification 1" Specification~T~
AndSpecification~T~ "1" o-- "rightSpecification 1" Specification~T~
OrSpecification~T~  "1" o-- "leftSpecification 1" Specification~T~
OrSpecification~T~  "1" o-- "rightSpecification 1" Specification~T~

SpecificationBuilder ..> AgeRangeSpecification : «create»
SpecificationBuilder ..> IdentitySpecification : «create»
SpecificationBuilder ..> InterestSpecification : «create»
SpecificationBuilder ..> Specification~UserProfile~ : «return»
```

### Matching

```mermaid
classDiagram
direction BT

class BiDirectionalStrategy {
    + BiDirectionalStrategy()
    + match(User user, List~User~ users, SpecificationBuilder builder) List~User~
}

class DefaultMatchStrategy {
    + DefaultMatchStrategy()
    + match(User user, List~User~ users, SpecificationBuilder builder) List~User~
}

class MatchStrategy {
    <<Interface>>
    + match(User user, List~User~ users, SpecificationBuilder builder) List~User~
}

class MatchingEngine {
    + MatchingEngine(List~User~ userList)
    + match(User user, SpecificationBuilder builder) List~User~
    - MatchStrategy matchStrategy
}

BiDirectionalStrategy --|> MatchStrategy
DefaultMatchStrategy --|> MatchStrategy

MatchingEngine ..> DefaultMatchStrategy : «create»
MatchingEngine "1" *--> "matchStrategy 1" MatchStrategy
```

### DTO

```mermaid
classDiagram
direction BT
class UserData {
  + UserData() 
  - int age
  - List~String~ interests
  - List~GenderIdentity~ preferedGenderIdentity
  - String name
  - int preferedMaxAge
  - String matchStrategy
  - SexualOrientation sexualOrientation
  - GenderIdentity genderIdentity
  - int preferedMinAge
  - boolean premium
  - String bio
  - List~String~ preferedInterests
   int preferedMinAge
   String name
   String bio
   String matchStrategy
   List~String~ interests
   GenderIdentity genderIdentity
   int preferedMaxAge
   SexualOrientation sexualOrientation
   int age
   List~GenderIdentity~ preferedGenderIdentity
   List~String~ preferedInterests
   boolean premium
}
class UserMapper {
  + UserMapper() 
  + toDTO(User) UserData
  + toEntity(UserData) User
}

UserMapper  ..>  UserData : «create»
```