/*
 * Copyright 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

  
  
  
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.groboot.grobootpushlibrary.GCMBaseIntentService;
import com.groboot.grobootpushlibrary.PushManager;
/**
 * IntentService responsible for handling GCM messages.
 */
public class GCMIntentService extends GCMBaseIntentService {
	  
    private final static int NOTIFICATION_ID = 9999;
  
    public static final String TAG = "GCMIntentService";
    public static final String SENDER_ID = "";
  
    public GCMIntentService() {
        super(SENDER_ID);
    }
  
    @Override
    protected void onRegistered(Context context, String registrationId) {
    	Log.d(TAG, "Device onRegistered " + registrationId);
    }
  
    @Override
    protected void onUnregistered(Context context, String registrationId) {
        Log.d(TAG, "Device onUnregistered " + registrationId);
    }
  
    @Override
    protected void onMessage(Context context, Intent intent) {
        Bundle data = intent.getExtras();
        if (data != null) {
            Intent notificationIntent = new Intent();
            notificationIntent.setClass(context, Hotel4UActivity.class);
            notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PushManager.buildNotification(intent.getExtras(), context,
                    NOTIFICATION_ID, R.drawable.ic_launcher, notificationIntent);
        }
  
    }
  
  
    @Override
    protected void onDeletedMessages(Context context, int total) {
    }
  
    @Override
    public void onError(Context context, String errorId) {
    }
  
    @Override
    protected boolean onRecoverableError(Context context, String errorId) {
        return super.onRecoverableError(context, errorId);
    }
}

