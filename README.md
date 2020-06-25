# name-scoring-rule-engine
## This is the API for Scoring Names Based on Algorithms

In this Exercise, the following Assumptions were made:
1. The Input Will Include a Flag to Identify which Rule/Algorithm the Score is expected to use. i have designated the following samples for the 3 expected variants of the algorithm:
     - "CURRENT" -- For The Current Algorithm Implementation
     - "FUTURE" -- For Future Algorithm Implementation
     - "ANOTHERDEPARTMENT" -- For Another Department's Algorithm Implementation
  Please Note the Minor twicks were made to differentiate those algorithms for now since no define algorithm for Future and Another Department Yet
  
  2. Based on the instructions given, I have designed the code in a way to encourage decoupling and separation of concerns. This will allow for maintainability and readability.
  In order to ensure optimized processing and cleaner, less boiler plate coding, I have used latest Java APIs. 
  
  Finally, Spring boot and Maven are used in order to ensure easy enhancement and well coordinated dependency and library management especially for integrating with third party APIs.
