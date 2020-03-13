GraphQL Example
=========
A simple example of consuming data using GraphQL 

Background
--------------
The data is obtained using the [Rick & Morty API](https://rickandmortyapi.com/)

Motivation
----------------
I was introduced to the topic of GraphQL, but I hadn't seen any examples. When I started to take a look, I realised a lot of the examples I had come across were deprecated, so I thought I would read the docs, build something to teach myself and hopefully, help others.  

Steps to reproduce
-------------------
This project uses the Apollo SDK - first, go to the [Apollo](https://www.apollographql.com/docs/android/essentials/get-started/) site to check out how to add Apollo-Android to your Project.

In regards to Downloading a schema.json file, the Apollo documentation states to run the following command: `./gradlew :module:downloadApolloSchema -Pcom.apollographql.apollo.endpoint=https://rickandmortyapi.com/graphql/ -Pcom.apollographql.apollo.schema=src/main/graphql/com/example/schema.json`

If you're on a windows machine make sure you use the commond: `.\gradlew :module:downloadApolloSchema -Pcom.apollographql.apollo.endpoint=https://rickandmortyapi.com/graphql/ -Pcom.apollographql.apollo.schema=src/main/graphql/com/example/schema.json`

Please note, in the above command, you're putting your schema.json in the directory in the above command, so make sure it exists!

Design
-------------------
* GraphQL
* MVVM
* Koin
* Fragment
* RecyclerView
* CardView
* Glide

Additional Notes
-------------------

If you want to look at the GraphQL structure in this project, make sure you're in the project view. Then go to: `GraphQLExample\app\src\main\graphql\com\example`

From there you can see the `schema.json`, `.graphqlconfig` and `results.graphql`. The `results.graphql` contains the query used to get the relevant data back that we use to present to the user.
