A sample tool for running a deployment task which consists of a set of steps which must be run.

## yaml file:
```
---

ticketNumber: TEST-001
description: deploy blah blah template

environments:
  - name: pre
    host: aaa

  - name: prod
    host: bbb

steps:
  - name: copy blah.txt
    type: copy
    src: /home/tim/a/blah.txt
    dest: /home/tim/b/blah.txt

  - name: copy blah2.txt
    type: copy
    src: /home/tim/a/blah2.txt
    dest: /home/tim/b/blah2.txt

  - name: copy blah2.txt
    type: delete
    src: /home/tim/a/deleteme.txt
```

## usage:
java deployer.jar [yourfile.yaml]

## example output
```
Running Step: copy blah.txt
Failed
Completed
Running Step: copy blah2.txt
Failed
Completed
Running Step: copy blah2.txt
Completed
```
