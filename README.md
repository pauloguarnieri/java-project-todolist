# java-project-todolist

base URL:
https://todolist-rocketseat-oai7.onrender.com


USER ROUTES: 

CREATE (/users)
- criação de usuário;
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
      		"username":"exemple",
		"name": "example",
      		"password": "$2a$12$ebkmYriaX.Y6nFfB67RhJOyeuQNmmg6eL3A.uF2aQdN0vcbZc8j5m",
	    	"createdAt": "2023-10-14T17:24:59.934074504"
    	}

  
TASK ROUTES:

CREATE (/tasks)
- criação de task;
parametros:
	title - String
	description - String
	priority - String
	startAt - Date ("YYYY-MM-DDTHH:mm:ss")
	endAt - Date ("YYYY-MM-DDTHH:mm:ss")

headers:
	(basic auth)
 	user username - String
  	user password - String

request:
	example (request body):

  	{
		"title":"example title",
		"description":"example description",
		"priority": "high",
		"startAt": "2023-11-01T12:54:22",
		"endAt": "2023-12-12T12:25:55"
	}
 
response:
	example (response body):

	{
		"id": "f342d7fa-aa3a-4b7d-a2f8-df40f5f53ae7",
		"description": " example description",
		"title": "example title",
		"startAt": "2023-11-01T12:54:22",
		"endAt": "2023-12-12T12:25:55",
		"priority": "high",
		"idUser": "95e696ef-8df4-430c-9ee1-4ee2a2161129",
		"createdAt": "2023-10-14T21:17:26.887754989"
	}

LIST (/tasks)
- listagem de tasks;
parametros:
	-
headers:
	(basic auth)
 	user username - String
  	user password - String

request:
	-
response:
	example (response body):
	[
	{
		"id": "f342d7fa-aa3a-4b7d-a2f8-df40f5f53ae7",
		"description": " example description",
		"title": "example title",
		"startAt": "2023-11-01T12:54:22",
		"endAt": "2023-12-12T12:25:55",
		"priority": "high",
		"idUser": "95e696ef-8df4-430c-9ee1-4ee2a2161129",
		"createdAt": "2023-10-14T21:17:26.887754989"
	},
	]

 UPDATE (/tasks/<task_id>)
- edição de task;
parametros:
	***(opcionais)
	title - String
	description - String
	priority - String
	startAt - Date ("YYYY-MM-DDTHH:mm:ss")
	endAt - Date ("YYYY-MM-DDTHH:mm:ss")

headers:
	(basic auth)
 	user username - String
  	user password - String

request:
	example (request body):

  	{
		"description":"updated example description",
		"priority": "low"
	}
 
response:
	example (response body):

	{
		"id": "f342d7fa-aa3a-4b7d-a2f8-df40f5f53ae7",
		"description": "updated example description",
		"title": "example title",
		"startAt": "2023-11-01T12:54:22",
		"endAt": "2023-12-12T12:25:55",
		"priority": "low",
		"idUser": "95e696ef-8df4-430c-9ee1-4ee2a2161129",
		"createdAt": "2023-10-14T21:17:26.887754989"
	}
