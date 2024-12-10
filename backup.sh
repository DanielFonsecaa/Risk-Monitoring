#!/bin/bash

BACKUP_DIR="/home/daniel/IdeaProjects/riskMonitoring/backup_Dir"
DB="riskMonitoring"
TIME=$(date +%Y%m%d%H%M%S)
BACKUP_FILE="$BACKUP_DIR/db_backup_$TIME.sql"

mysqldump -u root -p $DB > $BACKUP_FILE

if [ $? -eq 0 ]; then
	echo "Backup created : $BACKUP_FILE"
else
	echo "Failed to create backup file"
	echo exit 1
fi
