# Chatbot with Clojure

As the first part of the assignment, park_chatbot project is created using Clojure to allow the user to be able to communicate about his walk in parks he can find in Prague as well as to find available types of dogs according to the features he would like to know. This chatbot interface is also aimed to be used later in the second part of the group assignment. This current chatbot solution generally follows the idea of the classical system [ELIZA](https://www.masswerk.at/elizabot/) system.

## Getting Started

This project is built in [Clojure](https://clojure.org/guides/getting_started) and [Clojure-opennlp](https://github.com/dakrone/clojure-opennlp), a library to interface with the OpenNLP (Open Natural Language Processing) functions to provide linguistic tools to perform on various blocks of text. [Leiningen](https://leiningen.org/) is also used as a package management/dependencies tool to execute this Clojure based chatbot solution.

### Requirement


### Installation

Download and install [Leiningen](https://leiningen.org/) 
(only if you don't have Leiningen.)

You can download the project directly from the master branch or clone it using gitbash:
```
git clone github.com/Stanley008/Symbolic_Computation_2019.git
cd Symbolic_Computation_2019
```

### Usage

#### Open the terminal from your project folder and run the following commands:

```
To talk to the chatbot:
lein run

To run a specific function from the chatbot:
lein repl
```


### Deliverables

Considered already having a REPL environment and upon running the program, the chatbot welcomes the user with a background music and communicates with the user about name, nickname (if any), and a general question. The user can respond such with an appropriate command. 

> add CLI example

Following the general conversation, the chatbot then informs the user of two options that the user can learn more, i.e., parks and dogs. Upon user's choice, the chatbot prompts respective dialogue structure that is designed to receive user's preferences and determine an appropriate result. 

> add CLI example for park and dog options

The chatbot then follows a dialogue structure, inspired by the ELIZA system, i.e. the chatbot will parse user's sentence and look for specific keywords to identify a suitable park that he can visit. The chatbot also allows you to terminate the dialogue at any time you wish but with an appropriate command. 

In general, the park_chatbot is able to provide basic textual information about avaiable parks in Prague (such as restaurant, restrooms) upon your request.

### Limitations

As a limitation, the 'background music' functionality requires the user to switch to 'add_bg_music' branch before running the program, due to the usage of a music library that includes many dependencies for the soundtrack. 

The chatbot can also be terminated upon the user's command, however the user is required to use certain keywords that are known by the chatbot when determining the termination. The list of exit keywords can be found in data.clj. 

As of now, the user is also required not to answer a question from the chatbot with a question due to the lack of functionality that reads the input to further provide suitable responses. This feature is however expected to be implemented in the future. 

### Secrets

We have also included some secrets in our park_chatbot. You will find them when you respond to the questions. 

Hints: 
- c h r i s t m a s
- c o n t r i b u t o r s
## References

- [ClojureDocs](https://clojuredocs.org/)
- [Clojure-opennlp](https://github.com/dakrone/clojure-opennlp)
- [ELIZA](https://en.wikipedia.org/wiki/ELIZA)
- [Git best practices](https://dev.to/bholmesdev/git-github-best-practices-for-teamsopinionated-28h7)
- [Prague Parks](http://www.praha.eu/jnp/cz/co_delat_v_praze/parky/index.html)
- [Readme guide](https://www.makeareadme.com/)
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
