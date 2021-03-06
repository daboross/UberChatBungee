/*
 * Copyright (C) 2013-2014 Dabo Ross <http://www.daboross.net/>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.daboross.bungeedev.nchat.data;

import java.util.HashMap;
import java.util.Map;

public class PlayerDatabase {

    private final Map<String, UserData> dataMap = new HashMap<>();

    public void removePlayer(String username) {
        dataMap.remove(username);
    }

    public boolean staffChatEnabled(String username) {
        UserData data = dataMap.get(username);
        return data != null && data.isStaffChatEnabled();
    }

    public void staffChatEnabled(String username, boolean enabled) {
        UserData data = dataMap.get(username);
        if (data == null) {
            data = new UserData();
            dataMap.put(username, data);
        }
        data.setStaffChatEnabled(enabled);
    }

    private static class UserData {

        private boolean staffChatEnabled;

        public void setStaffChatEnabled(boolean staffChatEnabled) {
            this.staffChatEnabled = staffChatEnabled;
        }

        public boolean isStaffChatEnabled() {
            return staffChatEnabled;
        }
    }
}
