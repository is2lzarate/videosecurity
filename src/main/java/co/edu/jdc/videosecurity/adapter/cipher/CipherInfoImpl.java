package co.edu.jdc.videosecurity.adapter.cipher;

import co.edu.jdc.videosecurity.usecase.port.CipherInfo;
import org.apache.commons.codec.digest.DigestUtils;

public class CipherInfoImpl implements CipherInfo {
        @Override
        public String encrypt(String text) {
            return DigestUtils.sha256Hex(text);
        }
}
