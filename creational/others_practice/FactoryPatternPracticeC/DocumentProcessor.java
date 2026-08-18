package FactoryPatternPracticeC;

public interface DocumentProcessor {
    public void LoadDocument();
    public void SaveDocument();
}

class PDFDocumentProcessor implements DocumentProcessor{
    public void LoadDocument(){
        System.out.println("Loading .PDf file");
    }
    public void SaveDocument(){
        System.out.println("Saving .PDF file");
    }
}

class DocxDocumentProcessor implements DocumentProcessor{
    public void LoadDocument(){
        System.out.println("Loading .docx file");
    }
    public void SaveDocument(){
        System.out.println("Saving .docx file");
    }
}

class TXTDocumentProcessor implements DocumentProcessor{
    public void LoadDocument(){
        System.out.println("Loading .txt file");
    }
    public void SaveDocument(){
        System.out.println("Saving .txt file");
    }
}

class ProcessorFactory{
    public DocumentProcessor getProcessor(String filename){
        if(filename.endsWith(".pdf")){
            return new PDFDocumentProcessor();
        }
        else if(filename.endsWith(".docx")){
            return new DocxDocumentProcessor();
        }
        else if(filename.endsWith(".txt")){
            return new TXTDocumentProcessor();
        }
        else return null;
    }
}

class Client{
    public static void main(String[] args) {
        ProcessorFactory factory = new ProcessorFactory();
        String file1 = "cv.pdf";
        String file2 = "cv.docx";
        String file3 = "sop.txt";

        DocumentProcessor file1DocumentProcessor = factory.getProcessor(file1);
        DocumentProcessor file2DocumentProcessor = factory.getProcessor(file2);
        DocumentProcessor file3DocumentProcessor = factory.getProcessor(file3);

        file1DocumentProcessor.SaveDocument();
        file3DocumentProcessor.LoadDocument();
    }
}