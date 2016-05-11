'use strict';

import React,  {NativeModules} from 'react-native'

const PushbotsManager = NativeModules.Pushbots;

class Pushbots  {
    constructor(){
    }
}

module.exports = {
  PushbotsManager,
  Pushbots
};
