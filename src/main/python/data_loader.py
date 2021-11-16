import requests, json, logging, argparse, os


SRC_BASE_PATH = "data/raw/{_date}"
DEST_BASE_PATH = "data/output/{_date}"

URL_COMMENT = "https://api.pushshift.io/reddit/search/comment/?subreddit=TIdaL"
URL_SUBMISSION =  "https://api.pushshift.io/reddit/search/submission/?q=TIdaL"

def arg_parser():
    parser = argparse.ArgumentParser(prog='myprogram')
    parser.add_argument('-yyyymmdd', help='script run date')
    args = parser.parse_args()
    #print(args)
    return args

def get_data(url):
    r = requests.get(url)
    try:
        json_data = r.json()
        logging.info("load from Reddit API OK")
        return json_data['data']
    except Exception as e:
        logging.error("save from Reddit API failed")

def check_path_exist(path):
    print ("========== check_path_exist ==========")
    print ("path = " + str(path))
    if os.path.isdir(path):
        logging.info("path = {} existed".format(path))
    else:
        logging.info("path = {} not existed, create...".format(path))
        os.mkdir(path)

def save_data(json_data, dest_file):
    path = '/'.join(dest_file.split("/")[:-1])
    check_path_exist(path)
    with open(dest_file, 'a') as f:
        for i in range(len(json_data)):
            try:
                #print (json_data[i])
                f.write(json.dumps(json_data[i]) + "\n")
                logging.info("save file OK : {}".format(dest_file))
            except Exception as e:
                logging.error("save file failed")

def run(url, dest_file):
    _data = get_data(url)
    save_data(_data, dest_file)   

if __name__ == '__main__':
    args = arg_parser()
    _date = args.yyyymmdd
    logging.info("processing date = {}".format(_date))

    print ("collect comment data ...")
    dest_path = SRC_BASE_PATH.format(_date=_date) + "/comment.json"
    run(URL_COMMENT, dest_path)

    print ("collect submission data ...")
    dest_path = SRC_BASE_PATH.format(_date=_date) + "/submission.json"
    run(URL_SUBMISSION, dest_path)