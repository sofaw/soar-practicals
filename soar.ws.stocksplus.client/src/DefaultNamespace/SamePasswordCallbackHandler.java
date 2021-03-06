package DefaultNamespace;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class SamePasswordCallbackHandler implements CallbackHandler {
	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for(Callback callback : callbacks) {
			WSPasswordCallback wspc = (WSPasswordCallback) callback;
			wspc.setPassword(wspc.getIdentifer());
		}
	}
}
