#!/bin/bash
BASEDIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
mysql -u root < "$BASEDIR/dropdb.sql"
mysql -u root < "$BASEDIR/user_and_database.sql"
if [[ $? -ne 0 ]]; then
    echo "user_and_database.sql generated an error"
    exit 1
fi
