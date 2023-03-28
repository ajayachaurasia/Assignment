### Create a Spring Boot REST app that exposes endpoints to

- Register a User with basic information, username, and password
- Upload, view and delete images after authorizing the username/password.
- Associate the updated list of images with the user profile
- View the User Basic Information and the Images
- Leverage the Imgur API i.e. the Spring Boot APP should integrate with Imgur API to upload, view and delete the images
https://apidocs.imgur.com/

### App Requirements
- Should use H2 (In-memory database) and JPA to store the user information with user name and password,
retrieve the user name and password to authenticate the user
- Integrate with imgur’s API to upload, view and delete images. No need to worry about albums or galleries
- Create only 1 account at Imgur for the app to integrate.
- No UI should be built. The requirements should be implemented using the REST API’s.

### What's done?
- App is able to signup and signin using H2 database and also enables spring security
- imgur integration