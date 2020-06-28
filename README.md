
# Interview Challenge - Cat Facts API

We would like you to write an application that provides a RESTful API onto third party data.

We have provided a core skeleton for a Java Spring Boot application. You are asked to use an external API that provides facts about cats. Documentation on the API can be found at: https://catfact.ninja/ and the main APIs that you will use will be one or both of https://catfact.ninja/facts and https://catfact.ninja/breeds

Initial endpoints have been defined at `/facts` and `/breeds` which will return a listing of all cat facts or all cat breeds respectively.

We would like you to add to this application with the following requirements:

#### Basic Requirements

* Expose suitably designed and implemented endpoints to retrieve the data from the `Cat Facts API Service` (already done for you 👍)
* Amend the `/facts` endpoint to return `fact`s filtered by an optional `q` parameter, for example `?q=Egypt`
* Add a feature that allows a user to limit the number of `breed`s that are returned from the `/breeds` endpoint based on an optional parameter
* Add an appropriate endpoint and show a data summary response showing the count of all breeds of cats grouped by their `coat` properties
    * The format of the response body can be either one of the following (up to you):
    
            // #1
            [
                {
                    "Semi-long": 2
                },
                ...
            ]
    
            // #2
            [
                {
                    "coat": "Semi-long",
                    "count": 2
                },
                ...
            ]
     
NOTE: While working through this exercise feel free to refactor and amend the code and the project structure as you see fit, although be 
prepared to explain your reasoning and judgement. As examples, you might consider things such as DRY, readability, ease-of-testing, separation 
of concerns, code-cleanliness, approachability/ accessibility etc.            


#### Stretch Goals

* Return `breed`s filtered by either a provided `coat` parameter AND/OR a provided `country` parameter
* Allow a specific `breed` record to be retrieved by a path parameter of the `breed` name
* Implement `pagination` behaviour that can be applied to one or both of the `fact` and `breed` endpoints

You are free to add additional functionality in addition to the above if you so wish.

You may tackle the problem in any suitable development environment. If you so wish, you can tackle the problem using a different language or framework. 

This challenge is intended to be completed by candidates of all levels and experience, so you should attempt to complete as much as you feel demonstrates your capability. There is no expectation that all candidates will be able to complete all parts of this challenge. There is no time limit, but time taken may be taken into consideration during assessment.
