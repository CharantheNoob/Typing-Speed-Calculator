let startTime, endTime;
let totalWords = 9;  // "The quick brown fox jumps over the lazy dog" has 9 words
let promptText = "The quick brown fox jumps over the lazy dog";

function startTest() {
    document.getElementById("user-input").value = "";
    document.getElementById("results").style.display = "none";
    document.getElementById("user-input").disabled = false;
    startTime = new Date().getTime();
    document.getElementById("user-input").focus();
}

function calculateTypingSpeed() {
    let userInput = document.getElementById("user-input").value;
    let wordsTyped = userInput.split(" ").filter(word => word.length > 0).length;

    let timeTaken = (new Date().getTime() - startTime) / 1000;  // Time in seconds
    let wpm = ((wordsTyped / timeTaken) * 60).toFixed(2);

    // Calculate errors
    let errors = countErrors(promptText, userInput);

    // Calculate accuracy
    let accuracy = ((1 - errors / promptText.length) * 100).toFixed(2);

    // Display results
    document.getElementById("wpm").textContent = "Words Per Minute (WPM): " + wpm;
    document.getElementById("accuracy").textContent = "Accuracy: " + accuracy + "%";
    document.getElementById("errors").textContent = "Errors: " + errors;

    if (userInput === promptText) {
        endTime = new Date().getTime();
        document.getElementById("results").style.display = "block";
    }
}

function countErrors(original, userInput) {
    let errors = 0;
    let minLength = Math.min(original.length, userInput.length);
    
    for (let i = 0; i < minLength; i++) {
        if (original.charAt(i) !== userInput.charAt(i)) {
            errors++;
        }
    }

    errors += Math.abs(original.length - userInput.length);
    return errors;
}
