# java-project-todolist


USER ROUTES: 

CREATE (/users/)
criação de usuário;
parametros:
    username - String
    name - String
    password - String

request:
  example (request body):

    {
      "username":"exemple",
      "name": "example",
      "password: "example123"
    }

response:
  example (response body):
    {
	    "id": "952baa80-b239-4012-823d-a228c27c210e",
	    "username": "example",
	    "name": "example",
	    "password": "$2a$12$ebkmYriaX.Y6nFfB67RhJOyeuQNmmg6eL3A.uF2aQdN0vcbZc8j5m",
	    "createdAt": "2023-10-14T17:24:59.934074504"
    }
