import LZ77.Lz77EncoderDecoder;
import Huffman.HuffmanEncoderDecoder;

import java.util.ArrayList;
import java.util.BitSet;

public class main {
    public static void main(String[] args) {

        String fileToCompress = "C:\\Users\\eyald\\Desktop\\genesis.txt";
        String GzipCompressFile = "C:\\Users\\eyald\\Desktop\\GzipCompressFile";
        String keyPath = "C:\\Users\\eyald\\Desktop\\myKey";


        String finalOutput = "C:\\Users\\eyald\\Desktop\\originalFile.txt";


        Lz77EncoderDecoder l = new Lz77EncoderDecoder(16, 2048);
        HuffmanEncoderDecoder huffman = new HuffmanEncoderDecoder();




        BitSet LZCompressedBitSet = l.CompressLz(fileToCompress, GzipCompressFile);
       huffman.Compress(LZCompressedBitSet, GzipCompressFile);

        ArrayList<Byte> decompressArray = huffman.decompress(GzipCompressFile, keyPath);
       l.deCompress(decompressArray, finalOutput);


    }


}
