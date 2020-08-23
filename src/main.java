import LZ77.Lz77EncoderDecoder;
import Huffman.HuffmanEncoderDecoder;

import java.util.ArrayList;
import java.util.BitSet;

public class main {
    public static void main(String[] args) {

        //Adjust base path and which file to compress
        final String basePath = "C:\\Users\\eyald\\Desktop\\";
        final String fileToCompress = basePath + "smiley.bmp";
        final int searchBufferSize = 64;
        final int windowSize = 2048;

        //do not adjust
        final String GzipCompressFile = basePath+"GzipCompressFile";
        final String keyPath = basePath+"myKey";
        final String finalOutput = basePath+"originalFile.txt";


        Lz77EncoderDecoder l = new Lz77EncoderDecoder(searchBufferSize, windowSize);
        HuffmanEncoderDecoder huffman = new HuffmanEncoderDecoder();


        BitSet LZCompressedBitSet = l.CompressLz(fileToCompress, GzipCompressFile);
        huffman.Compress(LZCompressedBitSet, GzipCompressFile);

        ArrayList<Byte> decompressArray = huffman.decompress(GzipCompressFile, keyPath);
        l.deCompress(decompressArray, finalOutput);


    }


}
