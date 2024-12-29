# Class Diagram

![uml](images/uml.png)

```mermaid
classDiagram
direction BT
class AgeRange {
  + AgeRange(int, int) 
  - int minAge
  - int maxAge
   int maxAge
   int minAge
}
class AgeRangeSpecification {
  + AgeRangeSpecification(int, int) 
  + isSatisfiedBy(UserProfile) boolean
}
class AndSpecification~T~ {
  + AndSpecification(Specification~T~, Specification~T~) 
  + isSatisfiedBy(T) boolean
}
class BasicUser {
  + BasicUser(String, UserProfile) 
  + BasicUser(UserProfile) 
  ~ String username
  ~ UserProfile userProfile
   String description
   String username
   boolean premium
   UserProfile userProfile
}
class BiDirectionalStrategy {
  + BiDirectionalStrategy() 
  + match(User, List~User~, SpecificationBuilder) List~User~
}
class DefaultCompatibilityMatrix {
  - DefaultCompatibilityMatrix() 
  - DefaultCompatibilityMatrix instance
  - getAllGenderIdentitiesExcluding(GenderIdentity) List~GenderIdentity~
  + getDefaultPreferencedGenderIdentities(SexualOrientation, GenderIdentity) List~GenderIdentity~
  - getOppositeGender(GenderIdentity) List~GenderIdentity~
  - getSameGender(GenderIdentity) List~GenderIdentity~
  - initializeDefaultMappings() void
   DefaultCompatibilityMatrix instance
   List~GenderIdentity~ allGenderIdentities
}
class DefaultMatchStrategy {
  + DefaultMatchStrategy() 
  + match(User, List~User~, SpecificationBuilder) List~User~
}
class DeiResources {
  + DeiResources() 
  + match(UserData) Response
  + createUser(UserData) Response
}
class GenderIdentity {
  + GenderIdentity() 
  + GenderIdentity(GenderIdentityEnum) 
  + GenderIdentity(GenderIdentityEnum, String) 
  - GenderIdentityEnum genderIdentityEnum
  - String genderIdentity
   String genderIdentity
   GenderIdentityEnum genderIdentityEnum
   String customGenderIdentity
}
class GenderIdentityEnum {
<<enumeration>>
  - GenderIdentityEnum(String) 
  - String displayName
  + valueOf(String) GenderIdentityEnum
  + values() GenderIdentityEnum[]
   String displayName
}
class IdentitySpecification {
  + IdentitySpecification(List~GenderIdentity~) 
  + isSatisfiedBy(UserProfile) boolean
}
class InterestSpecification {
  + InterestSpecification(List~String~) 
  + isSatisfiedBy(UserProfile) boolean
}
class JerseyConfig {
  + JerseyConfig() 
}
class JettyServer {
  + JettyServer() 
  + main(String[]) void
}
class Main {
  + Main() 
  + main(String[]) void
}
class MatchStrategy {
<<Interface>>
  + match(User, List~User~, SpecificationBuilder) List~User~
}
class MatchingEngine {
  + MatchingEngine(List~User~) 
  + match(User, SpecificationBuilder) List~User~
   MatchStrategy matchStrategy
}
class OrSpecification~T~ {
  + OrSpecification(Specification~T~, Specification~T~) 
  + isSatisfiedBy(T) boolean
}
class PreferenceProfile {
  + PreferenceProfile(List~GenderIdentity~, List~String~, AgeRange) 
  - List~GenderIdentity~ preferedGenderIdentity
  - AgeRange preferedAgeRange
  - List~String~ preferedInterests
   AgeRange preferedAgeRange
   List~GenderIdentity~ preferedGenderIdentity
   List~String~ preferedInterests
}
class PreferenceProfileBuilder {
  + PreferenceProfileBuilder() 
  - List~GenderIdentity~ preferedGenderIdentity
  - List~String~ preferedInterests
  + build() PreferenceProfile
  + setAgeRange(int, int) PreferenceProfileBuilder
  + addPreferenceGenderIdentity(GenderIdentityEnum) PreferenceProfileBuilder
  + addPreferenceGenderIdentityWithEnum(GenderIdentityEnum, String) PreferenceProfileBuilder
   List~GenderIdentityEnum~ preferedGenderIdentityWithEnum
   List~GenderIdentity~ preferedGenderIdentity
   List~String~ preferedInterests
}
class PremiumUser {
  + PremiumUser(UserProfile) 
  + PremiumUser(String, UserProfile) 
  - UserProfile userProfile
  - String username
   String description
   String username
   boolean premium
   UserProfile userProfile
}
class SexualOrientation {
<<enumeration>>
  + SexualOrientation() 
  + valueOf(String) SexualOrientation
  + values() SexualOrientation[]
}
class Specification~T~ {
<<Interface>>
  + or(Specification~T~) Specification~T~
  + isSatisfiedBy(T) boolean
  + and(Specification~T~) Specification~T~
}
class SpecificationBuilder {
  + SpecificationBuilder() 
  + buildSpecificationFromPreferences(UserProfile) Specification~UserProfile~
}
class User {
<<Interface>>
   String description
   String username
   boolean premium
   UserProfile userProfile
}
class UserData {
  + UserData() 
  - List~String~ interests
  - int preferedMinAge
  - int age
  - String name
  - List~GenderIdentity~ preferedGenderIdentity
  - String matchStrategy
  - GenderIdentity genderIdentity
  - int preferedMaxAge
  - String bio
  - boolean premium
  - List~String~ preferedInterests
  - SexualOrientation sexualOrientation
   String name
   int age
   String bio
   String matchStrategy
   List~String~ interests
   boolean premium
   GenderIdentity genderIdentity
   int preferedMaxAge
   SexualOrientation sexualOrientation
   int preferedMinAge
   List~GenderIdentity~ preferedGenderIdentity
   List~String~ preferedInterests
}
class UserFactory {
  - UserFactory() 
  - List~User~ users
  + createUser(String, UserProfile, boolean) User
  + clearUsers() void
  + addUser(User) void
  + createUser(UserProfile, boolean) User
   List~User~ users
}
class UserMapper {
  + UserMapper() 
  + toDTO(User) UserData
  + toEntity(UserData) User
}
class UserProfile {
  + UserProfile(String, int, GenderIdentity, SexualOrientation, String, List~String~) 
  - List~String~ interests
  - SexualOrientation sexualOrientation
  - String bio
  - int age
  - String name
  - PreferenceProfile preferenceProfile
  - GenderIdentity genderIdentity
   String name
   int age
   String bio
   String customGenderIdentity
   List~String~ interests
   GenderIdentity genderIdentity
   SexualOrientation sexualOrientation
   GenderIdentityEnum genderIdentityEnum
   PreferenceProfile preferenceProfile
}
class UserProfileBuilder {
  + UserProfileBuilder() 
  - GenderIdentity genderIdentity
  - List~String~ interests
  - int age
  - String bio
  - SexualOrientation sexualOrientation
  - String name
  + setGenderIdentity(GenderIdentityEnum, String) UserProfileBuilder
  + build() UserProfile
   String name
   int age
   String bio
   List~String~ interests
   GenderIdentity genderIdentity
   SexualOrientation sexualOrientation
   GenderIdentityEnum genderIdentityWithEnum
}
class UserService {
  + UserService() 
  + match(UserData) List~UserData~
  + createUser(UserData) User
}

AgeRangeSpecification  ..>  Specification~T~ 
AgeRangeSpecification  ..>  UserProfile 
AndSpecification~T~  ..>  Specification~T~ 
AndSpecification~T~ "1" *--> "leftSpecification 1" Specification~T~ 
BasicUser  ..>  User 
BasicUser "1" *--> "userProfile 1" UserProfile 
BiDirectionalStrategy  ..>  MatchStrategy 
BiDirectionalStrategy  ..>  Specification~T~ 
BiDirectionalStrategy  ..>  SpecificationBuilder 
BiDirectionalStrategy  ..>  User 
BiDirectionalStrategy  ..>  UserProfile 
DefaultCompatibilityMatrix  ..>  DefaultCompatibilityMatrix : «create»
DefaultCompatibilityMatrix "1" *--> "instance 1" DefaultCompatibilityMatrix 
DefaultCompatibilityMatrix  ..>  GenderIdentity : «create»
DefaultCompatibilityMatrix  ..>  GenderIdentityEnum 
DefaultCompatibilityMatrix "1" *--> "defaultMappings *" SexualOrientation 
DefaultMatchStrategy  ..>  MatchStrategy 
DefaultMatchStrategy  ..>  Specification~T~ 
DefaultMatchStrategy  ..>  SpecificationBuilder 
DefaultMatchStrategy  ..>  User 
DefaultMatchStrategy  ..>  UserProfile 
DeiResources  ..>  DeiResources 
DeiResources  ..>  UserData 
DeiResources  ..>  UserService : «create»
GenderIdentity "1" *--> "genderIdentityEnum 1" GenderIdentityEnum 
IdentitySpecification "1" *--> "preferedGenderIdentities *" GenderIdentity 
IdentitySpecification  ..>  Specification~T~ 
IdentitySpecification  ..>  UserProfile 
InterestSpecification  ..>  Specification~T~ 
InterestSpecification  ..>  UserProfile 
JettyServer  ..>  JerseyConfig 
JettyServer  ..>  JettyServer 
JettyServer  ..>  Main 
Main  ..>  BiDirectionalStrategy : «create»
Main  ..>  DefaultMatchStrategy : «create»
Main  ..>  GenderIdentityEnum 
Main  ..>  MatchingEngine : «create»
Main  ..>  PreferenceProfile 
Main  ..>  PreferenceProfileBuilder : «create»
Main  ..>  SexualOrientation 
Main  ..>  SpecificationBuilder : «create»
Main  ..>  User 
Main  ..>  UserFactory 
Main  ..>  UserProfile 
Main  ..>  UserProfileBuilder : «create»
MatchStrategy  ..>  SpecificationBuilder 
MatchStrategy  ..>  User 
MatchingEngine  ..>  DefaultMatchStrategy : «create»
MatchingEngine "1" *--> "matchingStrategy 1" MatchStrategy 
MatchingEngine  ..>  SpecificationBuilder 
MatchingEngine "1" *--> "candidates *" User 
OrSpecification~T~  ..>  Specification~T~ 
OrSpecification~T~ "1" *--> "leftSpecification 1" Specification~T~ 
PreferenceProfile "1" *--> "preferedAgeRange 1" AgeRange 
PreferenceProfile "1" *--> "preferedGenderIdentity *" GenderIdentity 
PreferenceProfileBuilder  ..>  AgeRange : «create»
PreferenceProfileBuilder "1" *--> "ageRange 1" AgeRange 
PreferenceProfileBuilder "1" *--> "preferedGenderIdentity *" GenderIdentity 
PreferenceProfileBuilder  ..>  GenderIdentity : «create»
PreferenceProfileBuilder  ..>  GenderIdentityEnum 
PreferenceProfileBuilder  ..>  PreferenceProfile : «create»
PreferenceProfileBuilder  ..>  PreferenceProfileBuilder 
PremiumUser  ..>  User 
PremiumUser "1" *--> "userProfile 1" UserProfile 
Specification~T~  ..>  AndSpecification~T~ : «create»
Specification~T~  ..>  OrSpecification~T~ : «create»
Specification~T~  ..>  Specification~T~ 
SpecificationBuilder  ..>  AgeRange 
SpecificationBuilder  ..>  AgeRangeSpecification : «create»
SpecificationBuilder  ..>  IdentitySpecification : «create»
SpecificationBuilder  ..>  InterestSpecification : «create»
SpecificationBuilder  ..>  PreferenceProfile 
SpecificationBuilder  ..>  Specification~T~ 
SpecificationBuilder  ..>  UserProfile 
User  ..>  UserProfile 
UserData "1" *--> "preferedGenderIdentity *" GenderIdentity 
UserData "1" *--> "sexualOrientation 1" SexualOrientation 
UserFactory  ..>  BasicUser : «create»
UserFactory  ..>  PremiumUser : «create»
UserFactory "1" *--> "users *" User 
UserFactory  ..>  UserProfile 
UserMapper  ..>  AgeRange 
UserMapper  ..>  PreferenceProfile 
UserMapper  ..>  PreferenceProfileBuilder : «create»
UserMapper  ..>  User 
UserMapper  ..>  UserData : «create»
UserMapper  ..>  UserFactory 
UserMapper  ..>  UserProfile 
UserMapper  ..>  UserProfileBuilder : «create»
UserProfile  ..>  DefaultCompatibilityMatrix 
UserProfile "1" *--> "genderIdentity 1" GenderIdentity 
UserProfile  ..>  GenderIdentityEnum 
UserProfile "1" *--> "preferenceProfile 1" PreferenceProfile 
UserProfile  ..>  PreferenceProfileBuilder : «create»
UserProfile "1" *--> "sexualOrientation 1" SexualOrientation 
UserProfileBuilder  ..>  GenderIdentity : «create»
UserProfileBuilder "1" *--> "genderIdentity 1" GenderIdentity 
UserProfileBuilder  ..>  GenderIdentityEnum 
UserProfileBuilder "1" *--> "sexualOrientation 1" SexualOrientation 
UserProfileBuilder  ..>  UserProfile : «create»
UserProfileBuilder  ..>  UserProfileBuilder 
UserService  ..>  BiDirectionalStrategy : «create»
UserService  ..>  MatchingEngine : «create»
UserService  ..>  SpecificationBuilder : «create»
UserService  ..>  User 
UserService  ..>  UserData 
UserService  ..>  UserFactory 
UserService  ..>  UserMapper 

```