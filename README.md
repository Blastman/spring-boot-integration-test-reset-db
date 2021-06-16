## Spring Boot: Resetting Database Between Integration Tests

This example project shows how to reset (truncate) the database between 
integration tests without having to rely on slowing down the tests even more
with a dirty context setting.

This project has the schema defined in the entity. This is to show that you can
create the schema by using a `schema.sql` file in the test resource directory which creates it.