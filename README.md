# Park_chatbot with Clojure

As the first part of the assignment, park_chatbot project is created using Clojure to allow the user to be able to communicate about his walk in parks he can find in Prague. This chatbot interface is also aimed to be used later in the second part of the group assignment. This current chatbot solution generally follows the idea of the classical system [ELIZA](https://www.masswerk.at/elizabot/) system.

## Getting Started

This project is built in [Clojure](https://clojure.org/guides/getting_started) and [Clojure-opennlp](https://github.com/dakrone/clojure-opennlp), a library to interface with the OpenNLP (Open Natural Language Processing) functions to provide linguistic tools to perform on various blocks of text. [Leiningen](https://leiningen.org/) is also used as a package management/dependencies tool to execute this Clojure based chatbot solution.

### Installation

Download and install [Leiningen](https://leiningen.org/) 
(only if you don't have Leiningen.)

You can download the project directly from the master branch or clone it using gitbash:
> git clone github.com/Stanley008/Symbolic_Computation_2019.git

> cd Symbolic_Computation_2019

### Usage

#### To talk to our Park_chatbot:
> lein run

#### To run a specific function from our Park_chatbot:
> lein repl

### Project Deliverables

Considered already having a REPL environment and upon running the program, the chatbot welcomes you with a background music. You can then communicate with the chatbot by an appropriate command. The chatbot then generally follows a dialogue structure, inspired by the ELIZA system, i.e. the chatbot will parse user's sentence and look for specific keywords to identify a suitable park that he can visit. The chatbot also allows you to terminate the dialogue at any time you wish but with an appropriate command. 

In general, the park_chatbot is able to provide basic textual information about avaiable parks in Prague (such as restaurant, restrooms) upon your request.

### Project Limitations

As a project limitation, the 'background music' functionality requires you to switch to 'add_bg_music' branch before running the program, due to the usage of a music library that includes many dependencies for the soundtrack.

As of now, you are also required not to answer a question from the chatbot with a question due to the lack of functionality that will read the input and can further provide suitable responses. It is however expected to be implemented in the future. 

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
