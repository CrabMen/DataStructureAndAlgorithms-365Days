#!/bin/sh

# Cannot create a new backup.
# A previous backup already exists in refs/original/
# Force overwriting the backup with -f
# 如果之前曾经执行过 git filter-branch 命令,在 refs/original/ 会有一个备份,这个时候需要删除备份,然后执行接下来的操作即可
git update-ref -d refs/original/refs/heads/master

git filter-branch --env-filter '

<<<<<<< HEAD
OLD_EMAIL="rabman@guoqiangdeMacBook-Pro-2.local"
=======
OLD_EMAIL="crabman@guoqiangdeMacBook-Pro-2.local"
>>>>>>> 9ad8861bfeb8ec4b06c03a842a2403607ad51a8a
CORRECT_NAME="CrabMen"
CORRECT_EMAIL="tobecrabman@163.com"

if [ "$GIT_COMMITTER_EMAIL" = "$OLD_EMAIL" ]
then
    export GIT_COMMITTER_NAME="$CORRECT_NAME"
    export GIT_COMMITTER_EMAIL="$CORRECT_EMAIL"
fi
if [ "$GIT_AUTHOR_EMAIL" = "$OLD_EMAIL" ]
then
    export GIT_AUTHOR_NAME="$CORRECT_NAME"
    export GIT_AUTHOR_EMAIL="$CORRECT_EMAIL"
fi
' --tag-name-filter cat -- --branches --tags
