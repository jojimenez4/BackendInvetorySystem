package com.project.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface IPbkdf2EncryptService {
    String generarHashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
    boolean validarPassword(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
