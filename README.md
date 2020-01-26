# Parkbot

Parkbot with image recognition system in Clojure as the ICA project in Symbolic Computation module

## Scope

Parkbot is a chatbot solution to communicate with and recommend users about their walk and dogs they can find in Prague parks. The communication is done by the parbot providing a series of questions, identifying preferences from users' answers, and giving appropriate answers accordingly. Furthermore, the parkbot solution follows the idea of the classical system [ELIZA](https://en.wikipedia.org/wiki/ELIZA).

In version 1.0, the parkbot is to provide a park that suits different types of facilities that users look for upon their textual inputs. Following version 1.0, the parkbot in version 2.0 is further enhanced with a trained image recognition network. As a result, the parkbot is able to identify appropriate dog type upon both textual and imagery input.

## Requirement

[Leiningen](https://leiningen.org/) 2.0 or higher

## Installation

Download and install Leiningen (only if you don't have Leiningen.)

You can download the project directly from the master branch or clone it using gitbash:
```
git clone github.com/Stanley008/Symbolic_Computation_2019.git
cd Symbolic_Computation_2019
```

## Dependencies

- [The Clojure Programming Language](https://github.com/clojure/clojure/) 
- [Natural Language Processing in Clojure (opennlp)](https://github.com/dakrone/clojure-opennlp)
- [A Neural Network Toolkit for Clojure](https://clojars.org/thinktopic/cortex)
- [Image Manipulation Library](https://clojars.org/thinktopic/think.image)
- [Image Processing Library for Clojure](https://clojars.org/net.mikera/imagez)

## Usage

Open the terminal from your project folder and run the following commands:

```
To talk to the parkbot: lein run

To run a specific function from the parkbot: lein repl
```

## Design and Deliverables

Considered already having a REPL environment and upon running the program, the parkbot welcomes the user with background music and communicates with the user about name, nickname (if any), and a general question.

##### Parkbot Intro
<img src="https://i.imgur.com/hv5BG0W.png">

Following the general conversation, the parkbot informs the user of two options: parks and dogs. Upon user's choice, the parkbot prompts respective dialogue structure that aims to learn user's preferences in order to determine an appropriate result that is within the parkbot's knowledge. The dialogue structures of both park and dog generally follow the same pattern, though that of dog can additionally identify the result based on an image from user. 

##### Park and Dog Options
<img src= "https://i.imgur.com/P3zDl6j.png">

### Park 

Upon choosing park option, the user is able to look for a park of his choice out of 13 parks in Prauge. The parkbot first provides a list of questionnaires, from which the user can respond 'yes' or 'no.' The parkbot then looks for the keyword from the question to match with user's answer. Keywords vary from restroom, cafe, restaurant to playground. The user is able to exit the chat with keywords that are within parkbot's knowledge at any time during the process or upon receiving the suitable result form the parkbot. The user is also given option to learn more about the opening hours of the park.

##### General Dialogue Tree about Park
<img src= "https://i.imgur.com/nYh7lnB.png">

### Dog 

In this option, the parkbot offers two dog breeds: Japanese Spitz and Rottweiler. There are two options to learn about the dog type, which are by using either textual information or an image. Hence, not only does the dog option follow similar dialogue tree as the park, it additionally has image classification that uses Artificial Neural Network to determine the result based on an image. Similar to park, the user can choose whether to learn historical or fun facts about the given dog breed upon receiving the result, followed by whether to exit the program. 

Since the accuracy of the image classification with pre-trained network model can only perform 68% at its best, it is important to note that the result may vary from appropriate to unable to trace in worst case, based on the specification of the image provided by the user and the imagery knowledge of the parkbot.

##### General Dialogue Tree about Dog with Text
<img src="https://i.imgur.com/z2wXRZ6.png">

##### General Dialogue Tree about Dog with Image
<img src="https://i.imgur.com/AmRBFmt.png">

### Conversation Status

Traditionally, the parkbot asks the user whether he wants to continue or exit the conversation upon receiving any result. That being said, the user is also able to exit the program at any time using various keywords that associte with terminition.

##### Continue Conversation
<img src= "https://i.imgur.com/EH7xedN.png">

##### Exiting Conversation
<img src= "https://i.imgur.com/kWkEoET.png">

## Limitations

As a limitation, the 'background music' functionality requires the user to switch to 'add_bg_music' branch before running the program, due to the usage of a music library that includes many dependencies for the soundtrack.

The parkbot can also be terminated upon the user's command, however the user is required to use certain keywords that are known by the parkbot when determining the termination. The list of exit keywords can be found in [data.clj](https://github.com/Stanley008/Symbolic_Computation_2019/blob/master/src/park_chatbot/data.clj).

Due to the maximal accuracy rate that the parkbot can perform for the image classification, it is possible for the user to not receive appropriate response if the given image is not from within the parkbot’s knowledge.

As of now, the user is also required not to answer a question from the parkbot with a question due to the lack of functionality that reads the input to further provide suitable responses. This feature is however expected to be implemented in the future.

## Secrets

As a token of appreciation from the contributors, the parkbot contains some secrets to make it fun with certain festive themes. The user will encounter this while communicating with the parkbot about parks and dogs. 

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
