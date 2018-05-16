package env.java.io;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class InputStream {
	static final int HTTP_OK = 200;
	static final char EOL = '\n';
	static final int CONTENT_LENGTH = 3;

	final static String HEADER =
		"HTTP/1.1 " + HTTP_OK + " OK" + EOL +
		"Content-Length: " + CONTENT_LENGTH + EOL +
		"Accept-Ranges: bytes" + EOL;
	int pos; // denotes position in header
	int start; // position in data

	public InputStream() {
		pos = 0;
		start = 0;
	}

	public void close() {
	}

	/** TODO: Implement the read operation for the HTTP payload.
	  * This means the same data has to be returned as in sendFile in
	  * the web server. */
	public int read(byte[] b, int off, int len) {
		if (start >= CONTENT_LENGTH) {
			return -1;
		}
		for (int i = 0; i < len; i++)
			b[i] = (byte) ('a' + (start + i));
		return 0;
	}

	/** TODO: Implement the read operation for the HTTP header.
	  * This means that the next character in HEADER has to be
	  * returned, or -1 if the end has been reached. */
	public int read() {
		if (pos < HEADER.length()) {
			return (int)HEADER.charAt(pos++);
		}
		return -1;
	}
}
