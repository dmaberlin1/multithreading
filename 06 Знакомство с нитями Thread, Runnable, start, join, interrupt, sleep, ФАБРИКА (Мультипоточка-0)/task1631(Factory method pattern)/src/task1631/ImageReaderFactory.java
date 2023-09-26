package task1631;

import task1631.common.*;

public class ImageReaderFactory {

    public ImageReaderFactory() {
    }

    protected static ImageReader getImageReader(ImageTypes img) {
        ImageReader imageReader = null;
        if (img == ImageTypes.JPG) {
            imageReader = new JpgReader();
        } else if (img == ImageTypes.PNG) {
            imageReader=new PngReader();
        } else if (img==ImageTypes.BMP) {
            imageReader=new BmpReader();
        } else throw new IllegalArgumentException("Неизвестный тип картинки");

        System.out.println(imageReader);
        return imageReader;
    }
}
