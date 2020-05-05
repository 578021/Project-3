package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint;
	
	public static BigInteger hashOf(String entity)  {
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.

		// we use MD5 with 128 bits digest
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// compute the hash of the input 'entity'
		byte[] messageDigest = md.digest(entity.getBytes());
		// convert the hash into hex format
		String hex = toHex(messageDigest);
		// convert the hex into BigInteger
		hashint = new BigInteger(hex,16);
		// return the BigInteger
		return hashint;
	}
	
	public static BigInteger addressSize()  {
		
		// Task: compute the address size of MD5
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			int lengde = md.getDigestLength();
			int bitnr = lengde*8;
			BigInteger storrelse = (new BigInteger("2").pow(bitnr));
			return storrelse;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// get the digest length

		// compute the number of bits = digest length * 8

		// compute the address size = 2 ^ number of bits

		// return the address size
		
		return null;
	}
	
	public static int bitSize() throws NoSuchAlgorithmException {
		
		int digestlen = 0;

		MessageDigest md = MessageDigest.getInstance("MD5");
		// find the digest length
		digestlen = md.getDigestLength();
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
