package views;


import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

import javax.swing.*;

public class PDFPreview {

    private String filePath;

    public PDFPreview(){
        this.filePath = "src/main/exportedfile/Report.pdf";

        SwingController controller = new SwingController();
        SwingViewBuilder factory = new SwingViewBuilder(controller);
        JPanel viewerComponentPanel = factory.buildViewerPanel();

        controller.getDocumentViewController().setAnnotationCallback(new org.icepdf.ri.common.MyAnnotationCallback(controller.getDocumentViewController()));

        JFrame applicationFrame = new JFrame();

        applicationFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        applicationFrame.add(viewerComponentPanel);

        controller.openDocument(filePath);

        applicationFrame.pack();
        applicationFrame.setVisible(true);
    }


}
