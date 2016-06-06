# NAVQDSL

## 6NAVQDSL
* Ivo Fernandes , up201303199, Grade: 18, Contribution: 25%
* Carlos Samouco, up201305187, Grade: 18, Contribution: 25%
*	Gonçalo Lopes , up201303198, Grade: 18, Contribution: 25%
* José Teixeira , up201303930, Grade: 18, Contribution: 25%



### Summary
Our tool enables the user to specify routes and places through a natural language like manner. We use a Java server that runs the parser and a web interface to be used as a user interface to receive the user input and show the query results.

Our language handles all the possible options that the Google maps _API_ offers, we also integrated the places _API_.

### Dealing with Syntactic Errors
If the tool detects syntactic errors it returns to the user an error message, specifying what went wrong.

### Semantic Analysis
We analyzed the Google _API_ and identified some semantic errors that we would need to be aware of:
* specifying multiple means of transport, multiple by definitions.
* specifying multiple locations for places, multiple near definitions.
* LESS_WALKING, FEWER_TRANSFERS optimization options can only be used when the means of transport is Transit as well as the options ARRIVAL_TIME and DEPARTURE_TIME.
* OPTIMIZE_ROUTE option can only be used if the user defines two or more waypoints
* If specifying more than one mean of transport, must specify {train, tram, subway}


### Intermediate Representations (IRs)
Using the interface it is possible to visualize the intermediate representation tree generated for the provided input.

### Overview
Our tool is divided in three major parts, the parser, the server and the web interface.
We use a _JSON_ java library to create _JSON_ objects to respond to the requests, Treant.js used to visualize the _AST_ generated by the user input and raphael.js necessary to use the Google maps _API_.

### Task Distribution
* Ivo Fernandes - web interface, _JSON_ parsing and syntactic analysis.
* Carlos Samouco -
*	Gonçalo Lopes - Lexical Analysis, Syntactic Analysis, Semantic Analysis, generating _JSON_ for AST
* José Teixeira -

### How to use

For the web browser to communicate with our native Java program it is needed to open a socket and have it listening to the 8080 port. That said, it is necessary for a server to be running on the user's machine.

So step by step the user has to:

* Open the web interface (located on /interface/index.html)
* Start the Java application (run /compiler/Server.java)

After these steps the user can type in the input field on the web interface.

Note that Internet connection is needed.

### Pros

A fun implementation of a compiler course project.

Good interface and error display.

Fully functional as a NAVQDSL.  

AST visual display.


### Cons

 (Identify the most negative aspects of your tool)
