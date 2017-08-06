-- readme---
List of APIs used:

- RestEasy for restfull webservices
- Hibernate 4

Object oriented concepts used:
-	Interface based implementation for DAO and Service layer
-	Abstract class used for Generic DAO class (Hibernate CRUD operations)
-	Singleton HibernateConnector class used for getting hibernate sessions
-	Singleton Service layer classes implemented for business logic
-	Used Jackson for producing and consuming json data


cUrl Commands:

1)	curl -u divyeshc@gmail.com:xyz12345 -i -H 'Content-Type:application/json' http://localhost:7070/RestHibernateCRUD/rest/note/getNote/1

2)	curl -u divyeshc@gmail.com:xyz12345 -i -H 'Content-Type:application/json' http://localhost:7070/RestHibernateCRUD/rest/note/addNote/1
Post body
{"title":"fifth note","note":"This is my fifth note","createTime":1501871400000,"lastUpdateTime": 1501957800000}

3)	curl -u divyeshc@gmail.com:xyz12345 -i -H 'Content-Type:application/json' http://localhost:7070/RestHibernateCRUD/rest/note/deleteNote/1

4)	curl -u divyeshc@gmail.com:xyz12345 -i -H 'Content-Type:application/json' http://localhost:7070/RestHibernateCRUD/rest/note/updatetNote/5
Post body
{"title":"fifth note2","note":"This is my fifth note","createTime":1501871400000,"lastUpdateTime": 1501957800000}
