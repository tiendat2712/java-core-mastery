git init
git status
    : untracked: mới tạo ra
    : unmodified x: mới được commit
    : modified    : trước đó đã commit --> sửa
    : staged: ready to commit
git add
git commit -m "...." --> git config --global user.name ".."
git log [--oneline]
git ls-tree -hash-
git checkout -hash-

============================================
HEAD:
    + con trỏ
    + có duy nhất 1 con trỏ HEAD

master:
    + nhánh
    + con trỏ
    + có thể có rất nhiều nhánh vs tên bất kì