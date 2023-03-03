
//Works with the direct send text function
function submit_data(){
    var toNumber =  document.getElementById("toNumber").value;
    var messageData = document.getElementById("message").value;
    if (toNumber == ''){
        toNumber = null;
    }
    console.log(toNumber);
    console.log(messageData);

    if (toNumber != null){
        var body = messageParse(toNumber,messageData);
        return (sendText(body));
    }
    else{
        console.error("Null value detected in texting number");
    }
}



//Returns json file of the information passed throughs
function messageParse(number, text){
    var dict = {
        'toPhoneNumber': number,
        'text': text
    }

    return(JSON.stringify(dict));
}

//Utilizes application to send text message
function sendText(text){
    console.log("Sending Text");
    console.log(text);

    fetch('http://localhost:8200/texting/', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
        body: text}
    )
    .then(function (response) {
        return response.json();
    })
    .then(function (data) {
        console.log(data.status)
    sa});
    return false;

}



function add_number(){
    var toNumber = document.getElementById("toPhoneNumber").value;
    return;

}

function add_contact(){
    var fname = document.getElementById('fname').value;
    var lname = document.getElementById('lname').value;
    var phoneNumber = document.getElementById('phoneNumber').value;

    dict = {
        'fname':fname,
        'lname':lname,
        'phoneNumber':phoneNumber 
    }
    postBody = JSON.stringify(dict)

    fetch('http://localhost:8200/users',{
    method: 'POST',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
    body: postBody})
}

// function get_users(){
//     fetch('http://localhost:8200/users/')
// }

