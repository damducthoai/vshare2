package vshare.common.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import vshare.common.service.UniqueStringService;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Service("uniqueStringService")
public class UniqueStringServiceImpl implements UniqueStringService {
    public static final String BASE_STRING = String.valueOf(new Date());
    private static final AtomicLong ATOMIC_LONG = new AtomicLong();

    @Override
    public String getUniqueString() {
        long cur = ATOMIC_LONG.incrementAndGet();
        return DigestUtils.md5Hex(BASE_STRING.concat(Long.toString(cur)));
    }

    @Override
    public String getShortString() {
        // TODO
        return getUniqueString();
    }


}
