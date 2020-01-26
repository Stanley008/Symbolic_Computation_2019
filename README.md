# Chatbot (change name probly)

Chatbot solution with expert system in Clojure as part of ICA project in Symbolic Computation module

## Scope

CHATBOT (name) is a chatbot solution to communicate with and recommend users about their walk and dogs they can find in Prague parks. The communication is done by the chatbot providing a series of questions, identifying preferences from users' answers, and giving appropriate answers accordingly. Furthermore, the chatbot solution follows the idea of the classical system ELIZA system.

In version 1.0, the chatbot is to provide a park that suits different types of facilities that users look for upon their textual inputs. Following version 1.0, the chatbot in version 2.0 is further enhanced with a trained image recognition network. As a result, the chatbot is able to identify appropriate dog type upon both textual and imagery input.

### Requirement

[Leiningen](https://leiningen.org/) 2.0 or higher

### Installation

Download and install Leiningen (only if you don't have Leiningen.)

You can download the project directly from the master branch or clone it using gitbash:
```
git clone github.com/Stanley008/Symbolic_Computation_2019.git
cd Symbolic_Computation_2019
```

### Usage

#### Open the terminal from your project folder and run the following commands:

```
To talk to the chatbot: lein run

To run a specific function from the chatbot: lein repl
```

### Design and Deliverables

Considered already having a REPL environment and upon running the program, the chatbot welcomes the user with background music and communicates with the user about name, nickname (if any), and a general question.

> cli for chatbot intro

Following the general conversation, the chatbot informs the user of two options: parks and dogs. Upon user's choice, the chatbot prompts respective dialogue structure that aims to learn user's preferences in order to determine an appropriate result that is within the chatbot's knowledge. The dialogue structures of both park and dog generally follow the same pattern, though that of dog can additionally identify the result based on an image from user. 

As to maintain such functionalities with optimal efficiency in codes, database and technical solutions of general questionnaires, parks, and dogs are stored in separate .clj files as data and core respectively, which can be found in [park_chatbot](link). Core files are used to implement general algorithms of program, i.e., main loop, conversation flow, program termination followed by keyword mapping algorithms to determine appropriate responses by parsing user's input for keywords that are used to match with keywords from the database. The database, on the other hand, is stored in data files with appropriate clojure namespaces, classes, and functions such as defrecord (a two-factory function -> TypeName, taking positional parameters for the fields, and map-> TypeName, taking a map of keywords to field values) with def (a vector of objects).

> cli screenshot for park and dog options

#### Park 

Upon choosing park option, the chatbot provides a list of questionnaires, from which the user can respond 'yes' or 'no.' The match algorithm is that the chatbot parses the keyword from the question using park record and matches it with that from the user record in order to update the response respectively. Keywords vary from restroom, cafe, restaurant to playground. Despite having a strict dialogue tree in prompting user's preferences, the chatbot is able to provide a variation of textual statements along with an appropriate response about park as well as its opening hours and prompt whether the user wants to continue or terminate the chat. That being said, the chatbot also allows the user to exit the chat with keywords that are within chatbot's knowledge at any time he wishes. 

> 2 cli screenshots for park dialogue (one -> 3 q&a, exit word, continue convo | two -> same but exit convo)

#### Dog 

In this option, the user is given options to learn about the dog type by using either textual information or an image. Hence, not only does the dog option follow similar dialogue tree as the park, it additionally has image classification that uses Artificial Neural Network to determine the result based on an image. 

With the textual input, the chatbot can recognize the type of dog the user looks for using similar algorithms and data storage as the park. With the image, however, the chatbot first locates the image from the path given by the user and based on the image, it identifies the dog breed using pre-trained network model as well as dependencies. Since the accuracy of the image classification with pre-trained network model can only perform 68% at its best, it is important to note that the result may vary from appropriate to unable to trace in worst case, based on the specification of the image provided by the user and the imagery knowledge of the chatbot.

As to make the dialogue both informative and fun, the chatbot further asks if the user wants to know fun/historical fact for both textual and imagery options after providing the appropriate breed type. The dog option also performs same algorithms as park for user's request to terminate the program. 

> 3 cli screenshots for dog dialogue (one -> text dialogue, continue convo | two -> image dialogue, continue convo | three -> either one with exit convo)

### Limitations

As a limitation, the 'background music' functionality requires the user to switch to 'add_bg_music' branch before running the program, due to the usage of a music library that includes many dependencies for the soundtrack. 

The chatbot can also be terminated upon the user's command, however the user is required to use certain keywords that are known by the chatbot when determining the termination. The list of exit keywords can be found in data.clj. 

Due to the maximal accuracy rate that the chatbot can perform for the image classification, it is possible for the user to not receive appropriate response if the given image is not from within the chatbot's knowledge. 

As of now, the user is also required not to answer a question from the chatbot with a question due to the lack of functionality that reads the input to further provide suitable responses. This feature is however expected to be implemented in the future. 

### Secrets

As a token of appreciation from the contributors, the chatbot contains some secrets to make it fun with certain festive themes. The user will encounter this while communicating with the chatbot about parks and dogs. 

Hints: 
- c h r i s t m a s
- e a s t e r 
- c o n t r i b u t o r s

## References

- [ClojureDocs](https://clojuredocs.org/)
- [Clojure-opennlp](https://github.com/dakrone/clojure-opennlp)
- [ELIZA](https://en.wikipedia.org/wiki/ELIZA)
- [Git best practices](https://dev.to/bholmesdev/git-github-best-practices-for-teamsopinionated-28h7)
- [Prague Parks](http://www.praha.eu/jnp/cz/co_delat_v_praze/parky/index.html)
- [Style guide](https://guide.clojure.style/)
- Švarný, P. (2019) Chatbot with Clojure. [assignment brief]. From a Symbolic Computation class, first provided on November 1, Prague College.

## License

Copyright © 2019 Htet Ein Yan, Stanislav Brusnicky, Virgiliu Tirdea

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary Licenses when the conditions for such availability set forth in the Eclipse Public License, v. 2.0 are satisfied: GNU General Public License as published by the Free Software Foundation, either version 2 of the License, or any later version, with the GNU Classpath Exception which is available at https://www.gnu.org/software/classpath/license.html.

## Contributors

- [Htet Ein Yan](https://github.com/einyan03)
- [Stanislav Brusnicky](https://github.com/Stanley008)
- [Virgiliu Tirdea](https://github.com/Tocrak) 
