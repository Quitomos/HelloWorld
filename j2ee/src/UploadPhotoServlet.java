import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

public class UploadPhotoServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = null;
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        factory.setSizeThreshold(1024 * 1024);

        List items = null;

        try {
            items = upload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        Iterator iter = items.iterator();

        while (iter.hasNext()) {
            FileItem item = (FileItem)iter.next();
            if (!item.isFormField()) {
                filename = System.currentTimeMillis() + ".jpg";
                String photoFolder = req.getServletContext().getRealPath("uploaded");
                File f = new File(photoFolder, filename);
                f.getParentFile().mkdirs();
                InputStream is = item.getInputStream();
                FileOutputStream fos = new FileOutputStream(f);
                byte b[] = new byte[1024 * 1024];
                int length = 0;
                while (-1 != (length = is.read(b))) {
                    fos.write(b, 0, length);
                }
                fos.close();
            }
            else {
                System.out.println(item.getFieldName());
                String value = item.getString();
                value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                System.out.println(value);
            }
        }
        String html = "<img width='200' height='150' src='uploaded/%s' />";
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.format(html, filename);
    }
}
