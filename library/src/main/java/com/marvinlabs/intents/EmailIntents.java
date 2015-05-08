/*
Copyright 2013 Vincent Mimoun-Prat

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.marvinlabs.intents;

import android.content.Intent;
import android.net.Uri;

/**
 * Provides factory methods to create intents to send emails
 *
 * @author Vincent Prat @ MarvinLabs
 */
public class EmailIntents {

    /**
     * Create an intent to send an email to a single recipient
     *
     * @param address The recipient address (or null if not specified)
     * @param subject The subject of the email (or null if not specified)
     * @param body    The body of the email (or null if not specified)
     * @return the intent
     */
    public static Intent newEmailIntent(String subject, String body, String address) {
        return newEmailIntent(subject, body, null, address);
    }

    /**
     * Create an intent to send an email with an attachment
     *
     * @param addresses  The recipients addresses (or null if not specified)
     * @param subject    The subject of the email (or null if not specified)
     * @param body       The body of the email (or null if not specified)
     * @param attachment The URI of a file to attach to the email. Note that the URI must point to a location the email
     *                   application is allowed to read and has permissions to access.
     * @return the intent
     */
    public static Intent newEmailIntent(String subject, String body, Uri attachment, String... addresses) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
        if (addresses != null) intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        if (body != null) intent.putExtra(Intent.EXTRA_TEXT, body);
        if (subject != null) intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (attachment != null) intent.putExtra(Intent.EXTRA_STREAM, attachment);

        return intent;
    }

}
