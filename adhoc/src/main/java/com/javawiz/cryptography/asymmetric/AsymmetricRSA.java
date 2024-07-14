package com.javawiz.cryptography.asymmetric;

import jakarta.xml.bind.DatatypeConverter;
import javax.crypto.Cipher;
import java.security.*;

public class AsymmetricRSA {
    private static final String RSA = "RSA";
    public static void main(String[] args) throws Exception {
        KeyPair keypair = generateRSAKeyPair();
        PublicKey publicKey = keypair.getPublic();
        PrivateKey privateKey = keypair.getPrivate();
        System.out.println("Public Key is: "
                        + DatatypeConverter.printHexBinary(publicKey.getEncoded()));
        System.out.println("Private Key is: "
                        + DatatypeConverter.printHexBinary(privateKey.getEncoded()));

        String plainText = "javawiz";

        byte[] cipherText = encrypt(plainText,privateKey);
        System.out.println("The Encrypted Text is: "+DatatypeConverter.printHexBinary(cipherText));
        String decryptedText = decrypt(cipherText,publicKey);
        System.out.println("The decrypted text is: "+ decryptedText);
    }

    public static KeyPair generateRSAKeyPair() throws Exception {
        // SecureRandom class is used to generate random number.
        SecureRandom secureRandom = new SecureRandom();

        // The KeyGenerator class will provide getInstance() method which can be used to pass a string variable
        // which denotes the Key Generation Algorithm.
        // It returns KeyGenerator Object. We are using RSA algorithm for generating the keys.
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);

        keyPairGenerator.initialize(2048, secureRandom);

        return keyPairGenerator.generateKeyPair();
    }

    // Encryption function which converts the plainText into a cipherText using PrivateKey.
    public static byte[] encrypt(String plainText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(plainText.getBytes());
    }

    // Decryption function which converts the ciphertext back to the original plaintext.
    public static String decrypt(byte[] cipherText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return new String(cipher.doFinal(cipherText));
    }
}
