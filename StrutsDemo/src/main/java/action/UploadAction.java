package action;

import java.io.File;

public class UploadAction {
    private File doc;
    private String docFileName;
    private String docContentType;

    public String upload() {
        System.out.println(doc);
        System.out.println(docFileName);
        System.out.println(docContentType);
        return "success";
    }

    public File getDoc() {
        return doc;
    }

    public void setDoc(File doc) {
        this.doc = doc;
    }

    public String getDocContentType() {
        return docContentType;
    }

    public void setDocContentType(String docContentType) {
        this.docContentType = docContentType;
    }

    public String getDocFileName() {
        return docFileName;
    }

    public void setDocFileName(String docFileName) {
        this.docFileName = docFileName;
    }
}
