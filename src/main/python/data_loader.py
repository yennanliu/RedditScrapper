import requests, json, logging, argparse


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


def save_data(json_data, dest_file):
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
    url_comment = "https://api.pushshift.io/reddit/search/comment/?subreddit=TIdaL"
    url_dest_file = "data/raw/{}/comment.json".format(_date)
    run(url_comment, url_dest_file)

    print ("collect submission data ...")
    url_comment =  "https://api.pushshift.io/reddit/search/submission/?q=TIdaL"
    url_dest_file = "data/raw/{}/submission.json".format(_date)
    run(url_comment, url_dest_file)