var wsProtocol = 'ws://';
if (window.location.protocol === 'https:') {
    wsProtocol = 'wss://';
}
const wsUri = wsProtocol + document.location.host + document.location.pathname + "/endpoint";
const websocket = new WebSocket(wsUri);

websocket.onopen = function (event) {
    console.log("opened websocket: " + wsUri);
};