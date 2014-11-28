/**
 * Copyright (C) 2010-2012 Regis Montoya (aka r3gis - www.r3gis.fr)
 * This file is part of Fututel.
 *
 *  Fututel is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  If you own a pjsip commercial license you can also redistribute it
 *  and/or modify it under the terms of the GNU Lesser General Public License
 *  as an android library.
 *
 *  Fututel is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Fututel.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.fututel.wizards.impl;

import android.text.InputType;

import com.fututel.api.SipConfigManager;
import com.fututel.api.SipProfile;
import com.fututel.utils.PreferencesWrapper;

public class ClickPhone extends SimpleImplementation {

    @Override
    protected String getDomain() {
        return "sip.clickphone.ro";
    }

    @Override
    protected String getDefaultName() {
        return "ClickPhone";
    }
    
    /* (non-Javadoc)
     * @see com.fututel.wizards.impl.SimpleImplementation#fillLayout(com.fututel.api.SipProfile)
     */
    @Override
    public void fillLayout(SipProfile account) {
        super.fillLayout(account);
        accountUsername.getEditText().setInputType(InputType.TYPE_CLASS_PHONE);
    }

    /*
     * (non-Javadoc)
     * @see
     * com.fututel.wizards.impl.SimpleImplementation#buildAccount(com.fututel
     * .api.SipProfile)
     */
    @Override
    public SipProfile buildAccount(SipProfile account) {
        SipProfile acc = super.buildAccount(account);
        acc.reg_uri = "sip:sip.clickphone.ro:26999";
        acc.transport = SipProfile.TRANSPORT_UDP;
        acc.proxies = null;
        return acc;
    }

    @Override
    public void setDefaultParams(PreferencesWrapper prefs) {
        super.setDefaultParams(prefs);
        // Add stun server
        prefs.setPreferenceBooleanValue(SipConfigManager.ENABLE_STUN, true);
        prefs.addStunServer("stun.clickphone.ro");
    }

}