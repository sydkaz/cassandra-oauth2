===

Run application using:
mvn spring-boot:run

===

=== 

Get token using:
curl -X POST http://localhH 'authorization: Basic ZDZhMzdkODItY2U0ZS00OWI5LWExZjgtMmM1NWYyNTY3ZGNlOnNlY3JldA==' -F grant_type=password -F username=syed -F password=secret -F scope=trust
{"access_token":"43a906b4-5871-4127-bbfa-88a54f3a7958","token_type":"bearer","refresh_token":"ad97e1a6-235d-4f5b-ab05-717dce2d7cfd","expires_in":2591999,"scope":"trust"}

===

===

Fetch endpoing using token received in last request
curl -X GET http://localhost:8080/users -H 'authorization: Bearer 43a906b4-5871-4127-bbfa-88a54f3a7958'
