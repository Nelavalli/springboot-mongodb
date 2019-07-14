# springboot-mongodb
Standard Manual
  branch
    master
      Production delivery branch
      Tag every production release
      All feature branches merge into master
      Should not have any conflict while merging into master. Hence, Do the rebase of master in feature branch and do the confict resolution before merging feature branch to master
      Raise merge request which ensures code review
    develop
      All features will be implemented in develop branch

Stardard git command
  git clone https://github.com/Nelavalli/springboot-mongodb.git
  git checkout develop
  git log --graph --decorate --pretty=oneline --abbrev-commit
  git status
  git add .
  git commit -m "basic skelton"
  git push

Quick Info
  IDE - Intelli Idea
  build - gradle
  style formatter - google
  OS - Mac
  mongo - mongodb@4

Refer mongodb@4 mac install guide : https://docs.mongodb.com/manual/tutorial/install-mongodb-on-os-x/
Start mongo server (
