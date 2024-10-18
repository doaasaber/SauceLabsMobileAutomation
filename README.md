## steps to run locally

- make sure that Node is installed on your system otherwise you need to install


- make sure that appim is installed before running the tests
- if it is not installed then 
```

npm install -g appium

```
- start appium server execute below command

```
appium 
```

- you have freedom to install apium-doctor that will help on apium test environments
```
install -g appium-doctor

```

- While running the tests you might be facing issue like below

```
Process output: Fatal Error: Could not load the plugin 'relaxed-caps' because it is not installed. You don't have any plugins installed yet.
    at getActivePlugins (/usr/local/lib/node_modules/appium/lib/extension/index.js:106:15)
    at main (/usr/local/lib/node_modules/appium/lib/main.js:343:47)
```

- please install appium-plugin-relaxed-caps by executing below command

```
 appium plugin install --source=npm @appium/relaxed-caps-plugin
```

- make sure to install appium drivers

- to start appium for android execute below command
```
 appium --allow-cors --use-drivers uiautomator2 --base-path /wd/hub --use-plugins relaxed-caps
```

- to start appium for ios execute below command 

```
 appium --allow-cors --use-drivers xcuitest --base-path /wd/hub --use-plugins relaxed-caps
```



