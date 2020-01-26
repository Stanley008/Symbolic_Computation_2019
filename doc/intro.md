# Parkbot: Your Virtual Guide Through Prague Parks

## Overview

Chatbot project is created to allow users to be able to communicate about different types of facilities they look for in a park as well as dog breeds they would like to see based on their preferences. 

## Technology

Chatbot is built in Clojure and Clojure-opennlp, a library to interface with the OpenNLP (Open Natural Language Processing) functions to provide linguistic tools to perform on various blocks of text. The chatbot then further enhances with Neutral Network Deep Learning to implement image classification to recognize image input. Leiningen is also used as a package management/dependencies tool to execute this Clojure based chatbot solution.

## Dependencies

- [The Clojure Programming Language](https://github.com/clojure/clojure/) 
- [Natural Language Processing in Clojure (opennlp)](https://github.com/dakrone/clojure-opennlp)
- [A Neural Network Toolkit for Clojure](https://clojars.org/thinktopic/cortex)
- [Image Manipulation Library](https://clojars.org/thinktopic/think.image)
- [Image Processing Library for Clojure](https://clojars.org/net.mikera/imagez)

## Design and Deliverables

Considered already having a REPL environment and upon running the program, the chatbot welcomes the user with background music and communicates with the user about name, nickname (if any), and a general question.

<img src="https://i.imgur.com/hv5BG0W.png">

Following the general conversation, the chatbot informs the user of two options: parks and dogs. Upon user's choice, the chatbot prompts respective dialogue structure that aims to learn user's preferences in order to determine an appropriate result that is within the chatbot's knowledge. The dialogue structures of both park and dog generally follow the same pattern, though that of dog can additionally identify the result based on an image from user. 

As to maintain such functionalities with optimal efficiency in codes, database and technical solutions of general questionnaires, parks, and dogs are stored in separate .clj files as data and core respectively, which can be found in [park_chatbot](link). Core files are used to implement general algorithms of program, i.e., main loop, conversation flow, program termination followed by keyword mapping algorithms to determine appropriate responses by parsing user's input for keywords that are used to match with keywords from the database. The database, on the other hand, is stored in data files with appropriate clojure namespaces, classes, and functions such as defrecord (a two-factory function -> TypeName, taking positional parameters for the fields, and map-> TypeName, taking a map of keywords to field values) with def (a vector of objects).

> cli screenshot for park and dog options

### Park 

Upon choosing park option, the chatbot provides a list of questionnaires, from which the user can respond 'yes' or 'no.' The match algorithm is that the chatbot parses the keyword from the question using park record and matches it with that from the user record in order to update the response respectively. Keywords vary from restroom, cafe, restaurant to playground. Despite having a strict dialogue tree in prompting user's preferences, the chatbot is able to provide a variation of textual statements along with an appropriate response about park as well as its opening hours and prompt whether the user wants to continue or terminate the chat. That being said, the chatbot also allows the user to exit the chat with keywords that are within chatbot's knowledge at any time he wishes. 

> 2 cli screenshots for park dialogue (one -> 3 q&a, exit word, continue convo | two -> same but exit convo)

### Dog 

In this option, the user is given options to learn about the dog type by using either textual information or an image. Hence, not only does the dog option follow similar dialogue tree as the park, it additionally has image classification that uses Artificial Neural Network to determine the result based on an image. 

With the textual input, the chatbot can recognize the type of dog the user looks for using similar algorithms and data storage as the park. With the image, however, the chatbot first locates the image from the path given by the user and based on the image, it identifies the dog breed using pre-trained network model as well as dependencies. Since the accuracy of the image classification with pre-trained network model can only perform 68% at its best, it is important to note that the result may vary from appropriate to unable to trace in worst case, based on the specification of the image provided by the user and the imagery knowledge of the chatbot.

As to make the dialogue both informative and fun, the chatbot further asks if the user wants to know fun/historical fact for both textual and imagery options after providing the appropriate breed type. The dog option also performs same algorithms as park for user's request to terminate the program. 

> 3 cli screenshots for dog dialogue (one -> text dialogue, continue convo | two -> image dialogue, continue convo | three -> either one with exit convo)

## Limitations

As a limitation, the 'background music' functionality requires the user to switch to 'add_bg_music' branch before running the program, due to the usage of a music library that includes many dependencies for the soundtrack.

The chatbot can also be terminated upon the user's command, however the user is required to use certain keywords that are known by the chatbot when determining the termination. The list of exit keywords can be found in data.clj.

Due to the maximal accuracy rate that the chatbot can perform for the image classification, it is possible for the user to not receive appropriate response if the given image is not from within the chatbot's knowledge.

As of now, the user is also required not to answer a question from the chatbot with a question due to the lack of functionality that reads the input to further provide suitable responses. This feature is however expected to be implemented in the future.
