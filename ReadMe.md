# Mill Annotation Processor Development Sample

This project demonstrates how to create a simple annotation processor using Mill. 
It includes a custom annotation and an annotation processor that generates code based on that annotation.
The sample generates how to reference the annotation processor module from another mill module.

## Project Structure

```
root/
├── build.mill
├── samples/annotations
├── samples/processor/usage
└── samples/processors
```

## How to Use

1. **Clone the Repository**: 
   Clone this repository to your local machine.
2. **Navigate to the Project Directory**: 
   Open a terminal and navigate to the root directory of the project.
3. **Build the Project**: 
   Run the following command to build the project:
   ```bash
   ./mill __.compile
   ```
