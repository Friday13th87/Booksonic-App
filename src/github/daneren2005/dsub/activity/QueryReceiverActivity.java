/*
 This file is part of Subsonic.

 Subsonic is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 Subsonic is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with Subsonic.  If not, see <http://www.gnu.org/licenses/>.

 Copyright 2009 (C) Sindre Mehus
 */

package github.daneren2005.dsub.activity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;

import github.daneren2005.dsub.fragments.SubsonicFragment;
import github.daneren2005.dsub.util.Constants;
import github.daneren2005.dsub.util.Util;
import github.daneren2005.dsub.provider.DSubSearchProvider;

/**
 * Receives search queries and forwards to the SearchFragment.
 *
 * @author Sindre Mehus
 */
public class QueryReceiverActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String query = getIntent().getStringExtra(SearchManager.QUERY);

        if (query != null) {
            Intent intent = new Intent(QueryReceiverActivity.this, SubsonicFragmentActivity.class);
            intent.putExtra(Constants.INTENT_EXTRA_NAME_QUERY, query);
			intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Util.startActivityWithoutTransition(QueryReceiverActivity.this, intent);
        }
        finish();
        Util.disablePendingTransition(this);
    }
}