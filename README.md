# name-scoring-rule-engine
## This is the API for scoring Names based on algorithms

In this exercise, the following assumptions were made:
1. The Input will Include a Flag to Identify which Rule/Algorithm the Score is expected to use. i have designated the following samples for the 3 expected variants of the algorithm:
     - "CURRENT" -- For The Current Algorithm Implementation
     - "FUTURE" -- For Future Algorithm Implementation
     - "ANOTHERDEPARTMENT" -- For Another Department's Algorithm Implementation
          - Please note the minor adjustments were made to differentiate those algorithms for now since there is no defined algorithm for Future and Another Department Yet
  
  2. Based on the instructions given, I have designed the code in a way to encourage decoupling and separation of concerns. This will allow for maintainability and readability.
  In order to ensure optimized processing and cleaner, less boiler plate coding, I have used latest Java APIs where necessary. 
  JUnit Tests have also been written for almost all classes and passing.
  
  3. Finally, Spring boot and Maven are used in order to ensure easy enhancement and well coordinated dependency and library management especially for integrating with third party APIs.
  
## Assumptions before Runnig the Code
1. User must have Java Installed
2. User must have Maven installed
3. User should be able to build using mvn clean install from command line

## Steps to Execute this Code
1. Clone the code from https://github.com/MartGit/name-scoring-rule-engine.git to your local directory
2. In your terminal, navigate to the directory were the code is cloned
3. cd to name-scoring-rule-engine
3. Run mvn clean install 
4. Upon successful build run the following command
      - mvn spring-boot:run -Dspring-boot.run.arguments="[Path to file containing the names to score] [The Algorithm to Use]"
         - Please replace [Path to file containing the names to score] with your file path and replace the [The Algorithm to Use] with the first letter of any of the Algorithms already mentioned above that you intend to use for instance "C" for CURRENT.

## Expected OutPut
The Output is Expected as following sample output
   - Sum of All Scores Using CURRENT Algorithm Is 3185
      
