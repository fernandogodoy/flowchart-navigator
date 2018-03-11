# Flowchart Navigator

This project can be used as an option for iterative navigation in a flow diagram.
The goal is to read the diagram and navigate the drawn flow based on the elements.

### Lucidchart

Recognized elements:

	1 - Process : Element intermediate between a question and another
	2 - Decision: Element used to questions
	3 - Terminator: Element used to indicate end of flow

The diagram is exported to ".csv"

## How to Use

	1 - Draw your diagram and save.
	2 - Open the file "config.properties" and inform the path of your file.
	3 - Run the application using prompt
	
	
## Drawing

To draw your diagram use a "process" element to start and insert a "decision" element between one "process" and another until it reaches the end of the flow that is indicated by the element "terminator"

	
Example: https://www.lucidchart.com/invitations/accept/0ff79aa7-f57c-4353-826d-e788d350ef12