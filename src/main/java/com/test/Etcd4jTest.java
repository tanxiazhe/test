/**
 * 
 */
package com.test;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.junit.Test;

import mousio.etcd4j.EtcdClient;
import mousio.etcd4j.promises.EtcdResponsePromise;
import mousio.etcd4j.responses.EtcdAuthenticationException;
import mousio.etcd4j.responses.EtcdException;
import mousio.etcd4j.responses.EtcdKeysResponse;

/**
 * @author
 *
 */
public class Etcd4jTest {

    @Test
    public void test() throws IOException, EtcdException, EtcdAuthenticationException, TimeoutException {
        @SuppressWarnings("resource")
        EtcdClient client = new EtcdClient(URI.create("http://127.0.0.1:2379"));

        String key = "/message";
        // set the key
        EtcdResponsePromise<EtcdKeysResponse> promise = client.put(key, "beepboop").send();
        // get the value of the key
        EtcdResponsePromise<EtcdKeysResponse> value = client.get(key).send();
        // System.out.println(value);
        Assert.assertEquals("beepboop", value.get().node.value);
        // delete the key
        client.delete(key);
        value = client.get(key).send();
        // System.out.println(value);
        Assert.assertNull(value);
    }

}
