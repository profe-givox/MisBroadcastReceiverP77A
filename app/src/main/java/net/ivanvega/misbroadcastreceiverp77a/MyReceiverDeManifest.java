package net.ivanvega.misbroadcastreceiverp77a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class MyReceiverDeManifest extends BroadcastReceiver {

    private static final String TAG = "MyBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Action: " + intent.getAction() + "\n");
//        sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() +
//                "\n");
//        String log = sb.toString();
//        Log.d(TAG, log);
//
//        Toast.makeText(context, log, Toast.LENGTH_LONG).show();


        if (intent.getAction().equals("com.example.broadcast.MY_NOTIFICATION")){
                    StringBuilder sb = new StringBuilder();
            sb.append("Action: " + intent.getAction() + "\n");
            sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() +
                    "\n");
            String log = sb.toString();
            Log.d(TAG, log);

            Toast.makeText(context, log, Toast.LENGTH_LONG).show();

        }

        final PendingResult pendingResult = goAsync();
        Tarea asyncTask = new Tarea(pendingResult, intent);
        asyncTask.execute();

    }


    private static class Tarea extends AsyncTask<String, Integer, String>{
        private final PendingResult pendingResult;
        private final Intent intent;

        private Tarea(PendingResult pendingResult, Intent intent) {
            this.pendingResult = pendingResult;
            this.intent = intent;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "Antes del hardwork");
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d(TAG, s+"postexecute");

            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder sb = new StringBuilder();
            sb.append("Action: " + intent.getAction() + "\n");
            sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
            String log = sb.toString();
            Log.d(TAG, log);

            return log;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }


}
